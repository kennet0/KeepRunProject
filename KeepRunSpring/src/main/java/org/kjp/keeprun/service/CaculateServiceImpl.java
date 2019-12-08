package org.kjp.keeprun.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.kjp.keeprun.persistence.BoardDAO;
import org.kjp.keeprun.persistence.CalculateDAO;
import org.springframework.stereotype.Service;

@Service
public class CaculateServiceImpl implements CalculateService {

	@Inject
	CalculateDAO calculateDAO;
	
	@Override
	public void workTimeCalculator(int deviceId) {
		
		
		int workTime=calculateDAO.calWorkTime(deviceId);
		int distance=calculateDAO.calDistance(deviceId);
		int avgHR=calculateDAO.calAvgHR(deviceId);
		
		WorkProcessVO workProcessVO = new WorkProcessVO();
		workProcessVO.setDeviceId(deviceId);
		workProcessVO.setWorkTime(workTime);
		workProcessVO.setDistance(distance);
		
		
		calculateDAO.insertDayWorkProcess(workProcessVO);
	
	}

}
