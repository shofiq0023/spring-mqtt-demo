package com.mqttdemo.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mqttdemo.dao.UserTraceDao;
import com.mqttdemo.dto.UserTraceDto;
import com.mqttdemo.dto.UserTraceReqDto;
import com.mqttdemo.model.UserTraceModel;

@Service
public class UserTraceService {
	@Autowired
	private UserTraceDao userTraceDao;
	
	public void saveUserTrace(String strPayload) {
		System.out.println(">>>>>>>> Data received");
		
		try {
			UserTraceReqDto reqDto = new Gson().fromJson(strPayload, UserTraceReqDto.class);
			List<UserTraceModel> tracesToBeSaved = new ArrayList<UserTraceModel>();
			
			for (UserTraceDto traceDto : reqDto.getModelList()) {
				UserTraceModel traceModel = new UserTraceModel();
				
				traceModel.setUsername(traceDto.getUsername());
				traceModel.setBroadcastEnabled(traceDto.isBroadcastEnabled());
				
				traceModel.setLatitude(traceDto.getLatitude());
				traceModel.setLongitude(traceDto.getLongitude());
				traceModel.setRefNumber(traceDto.getRefNumber());
				
				traceModel.setVisitDate(Date.valueOf(traceDto.getVisitDate()));
				traceModel.setVisitTime(Timestamp.valueOf(traceDto.getVisitTime()));
				
				traceModel.setCreatedAt(new Date(System.currentTimeMillis()));
				traceModel.setCreatedOn(new Timestamp(System.currentTimeMillis()));
				
				tracesToBeSaved.add(traceModel);
			}
			
			if (tracesToBeSaved != null || !tracesToBeSaved.isEmpty()) {
				userTraceDao.saveAll(tracesToBeSaved);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
