package com.mqttdemo.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_location_traces")
public class UserTraceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String username;
	private Date visitDate;
	private Timestamp visitTime;
	private Date createdAt;
	private Timestamp createdOn;
	private float latitude;
	private float longitude;
	private String refNumber;
	private boolean broadcastEnabled;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Timestamp getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Timestamp visitTime) {
		this.visitTime = visitTime;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

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
		return "UserTraceModel [id=" + id + ", username=" + username + ", visitDate=" + visitDate + ", visitTime="
				+ visitTime + ", createdAt=" + createdAt + ", createdOn=" + createdOn + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", refNumber=" + refNumber + ", broadcastEnabled=" + broadcastEnabled
				+ "]";
	}

}
