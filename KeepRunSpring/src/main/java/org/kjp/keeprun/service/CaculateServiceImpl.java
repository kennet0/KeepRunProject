package org.kjp.keeprun.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.persistence.BoardDAO;
import org.kjp.keeprun.persistence.CalculateDAO;
import org.springframework.stereotype.Service;

@Service
public class CaculateServiceImpl implements CalculateService {

	@Inject
	CalculateDAO calculatorDAO;
	
	@Override
	public int workTimeCalculator(int deviceId) {
		List<DeviceDataVO> listData = calculatorDAO.dailyDeviceData(deviceId);
		Date minTime = null;
		Date maxTime = null;
		for(DeviceDataVO i : listData) {
			minTime=i.getSendTime();
			
			if (maxTime.compareTo(i.getSendTime())==-1) {
				maxTime=i.getSendTime();
			}
		}
//		long timeDiff =  maxTime.getTime() - minTime.getTime();
		
			
		return 0;
	}

}
