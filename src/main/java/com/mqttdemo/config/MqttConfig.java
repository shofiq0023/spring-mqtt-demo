package com.mqttdemo.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class MqttConfig {

    @Bean
    MqttPahoClientFactory mqttClientFactor() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		MqttConnectOptions connectOptions = new MqttConnectOptions();
		
		connectOptions.setServerURIs(new String[] {"tcp://localhost:1883"});
		connectOptions.setUserName("admin");
		connectOptions.setPassword("123456".toCharArray());
		connectOptions.setCleanSession(true);
		
		factory.setConnectionOptions(connectOptions);
		
		return factory;
	}
    
    @Bean
    MessageChannel mqttInputChannel() {
    	return new DirectChannel();
    }
    
    @Bean
    MessageChannel mqttOutboundChannel() {
    	return new DirectChannel();
    }
    
    @Bean
    MessageProducer inbound() {
    	MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("serverIn", mqttClientFactor(), "#");
    	
    	adapter.setCompletionTimeout(5000);
    	adapter.setConverter(new DefaultPahoMessageConverter());
    	adapter.setQos(2);
    	adapter.setOutputChannel(mqttInputChannel());
    	
    	return adapter;
    }
    
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    MessageHandler inboundMessageHandler() {
    	return new MessageHandler() {
			
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
				
				if (topic.equals("my_topic")) {
					System.out.println("Received out topic");
				}
				
				System.out.println(message.getPayload());
				
			}
		};
    }
    
    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    MessageHandler outboundMessageHandler() {
    	MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("serverOut", mqttClientFactor());
    	
    	messageHandler.setAsync(true);
    	messageHandler.setDefaultTopic("#");
    	messageHandler.setDefaultRetained(false);
    	
    	return messageHandler;
    }
}





















