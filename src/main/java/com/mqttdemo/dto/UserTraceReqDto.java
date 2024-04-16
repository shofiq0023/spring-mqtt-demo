package com.mqttdemo.dto;

import java.util.List;

public class UserTraceReqDto {
	private String apiKey;
	private String appCode;
	private String username;
	private List<UserTraceDto> modelList;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserTraceDto> getModelList() {
		return modelList;
	}

	public void setModelList(List<UserTraceDto> modelList) {
		this.modelList = modelList;
	}

	@Override
	public String toString() {
		return "UserTraceReqDto [apiKey=" + apiKey + ", appCode=" + appCode + ", username=" + username + ", modelList="
				+ modelList + "]";
	}

}
