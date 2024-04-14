package com.mqttdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mqttdemo.MessageGateway;

@RestController
public class MqttMessageController {
	@Autowired
	private MessageGateway messageGateway;

	@PostMapping("/send")
	public ResponseEntity<?> publicMessage(@RequestBody String mqttMessage) {
		
		try {
			JsonObject convertedObject = new Gson().fromJson(mqttMessage, JsonObject.class);
			messageGateway.sendToMqtt(convertedObject.get("message").toString(), convertedObject.get("topic").toString());
			
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok("Failed");
		}
		
	}
}
