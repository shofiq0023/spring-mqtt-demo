package com.mqttdemo.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mqttdemo.model.UserTraceModel;

public interface UserTraceDao extends JpaRepository<UserTraceModel, UUID>{

}
