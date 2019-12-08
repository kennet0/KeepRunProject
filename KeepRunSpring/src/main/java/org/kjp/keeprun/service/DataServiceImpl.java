package org.kjp.keeprun.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.kjp.keeprun.persistence.BoardDAO;
import org.kjp.keeprun.persistence.DataDAO;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

	@Inject
	DataDAO dataDAO;
	
	@Override
	public void workTimeCalculator(int deviceId) {
		
		
		int workTime=dataDAO.calWorkTime(deviceId);
		int distance=dataDAO.calDistance(deviceId);
		int avgHR=dataDAO.calAvgHR(deviceId);
		
		WorkProcessVO workProcessVO = new WorkProcessVO();
		workProcessVO.setDeviceId(deviceId);
		workProcessVO.setWorkTime(workTime);
		workProcessVO.setDistance(distance);
		
		
		dataDAO.insertDayWorkProcess(workProcessVO);
	
	}
	
	@Override
	public void insertA_data(DeviceDataVO deviceDataVO) {
	
		dataDAO.insertA_data(deviceDataVO);
	}

	@Override
	public List<MemberVO> userInfo() {
		
		return dataDAO.userInfo();
	}


}
