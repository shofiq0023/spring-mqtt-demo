package com.mqttdemo.config;

public enum MessageTopic {
	MY_TOPIC("myTopic"), USER_TRACE("userTrace");

	private String value;

	private MessageTopic(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
