package org.kjp.keeprun.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataController {
	
	@Inject
	DataService dataService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(DataController.class);
	
	@RequestMapping(value= "/dataUpdate")
	public void dataUpdate(HttpServletRequest request) {
		logger.info("dataUpdate");
		int deviceId = Integer.parseInt(request.getParameter("deviceID"));
		int userHR = Integer.parseInt(request.getParameter("userHR"));
		double gpsLatitude=Double.parseDouble("gpsLatitude");
		double gpsLongitude=Double.parseDouble("gpsLongitude");
				
	
		
		if(request.getParameter("deviceID")!=null) {
			if(request.getParameter("gpsLatitude")!=null && request.getParameter("gpsLatitude")!=null) {
				DeviceDataVO deviceDataVO = new DeviceDataVO();
				deviceDataVO.setDeviceId(deviceId);
				deviceDataVO.setUserHR(userHR);
				deviceDataVO.setGpsLatitude(gpsLatitude);
				deviceDataVO.setGpsLongitude(gpsLongitude);
				dataService.insertA_data(deviceDataVO);
			}else {
				DeviceDataVO deviceDataVO = new DeviceDataVO();
				deviceDataVO.setDeviceId(deviceId);
				deviceDataVO.setUserHR(userHR);
				dataService.insertA_data(deviceDataVO);
			}
				
		}
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date now = new Date();
		String nowCompareTime = format.format(now);
		
		if(nowCompareTime.equals("23:59:59")) {
			logger.info(nowCompareTime);
			for(MemberVO i:dataService.userInfo()) {
				dataService.workTimeCalculator(i.getDeviceId());
				
			}
		}
		
		
		
		
		
		
		
	}


}
