package com.mqttdemo.dto;

public class UserTraceDto {
	private float latitude;
	private float longitude;
	private String username;
	private String visitDate;
	private String visitTime;
	private String refNumber;
	private boolean broadcastEnabled;

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public String getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public boolean isBroadcastEnabled() {
		return broadcastEnabled;
	}

	public void setBroadcastEnabled(boolean broadcastEnabled) {
		this.broadcastEnabled = broadcastEnabled;
	}

	@Override
	public String toString() {
		return "UserTraceDto [latitude=" + latitude + ", longitude=" + longitude + ", username=" + username
				+ ", visitDate=" + visitDate + ", visitTime=" + visitTime + ", refNumber=" + refNumber
				+ ", broadcastEnabled=" + broadcastEnabled + "]";
	}

}
