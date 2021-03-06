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
		logger.info(request.getParameter("deviceID"));
		int deviceId = Integer.parseInt(request.getParameter("deviceID"));
		int userHR = 0;
		double gpsLatitude=0;
		double gpsLongitude=0;
		if(request.getParameter("userHR")!=null) {userHR = Integer.parseInt(request.getParameter("userHR"));}
		if(request.getParameter("gpsLatitude")!=null) {gpsLatitude=Double.parseDouble(request.getParameter("gpsLatitude"));}
		if(request.getParameter("gpsLongitude")!=null) {gpsLongitude=Double.parseDouble(request.getParameter("gpsLongitude"));}
		
		
		if(request.getParameter("deviceID")!=null) {
			if(request.getParameter("gpsLatitude")!=null && request.getParameter("gpsLongitude")!=null) {
				DeviceDataVO deviceDataVO = new DeviceDataVO();
				deviceDataVO.setDeviceId(deviceId);
				deviceDataVO.setUserHR(userHR);
				deviceDataVO.setGpsLatitude(gpsLatitude);
				deviceDataVO.setGpsLongitude(gpsLongitude);
				dataService.insertA_data(deviceDataVO);
				logger.info("Data DB In");
				
			}else {
				DeviceDataVO deviceDataVO = new DeviceDataVO();
				deviceDataVO.setDeviceId(deviceId);
				deviceDataVO.setUserHR(userHR);
				dataService.insertA_data(deviceDataVO);
				logger.info("HR DB In");
			}
		}
	}
}
