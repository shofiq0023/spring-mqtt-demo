package com.mqttdemo;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.integration.mqtt.support.MqttHeaders;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MessageGateway {
	void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}
