package org.kjp.keeprun.service;

import java.util.List;

import javax.inject.Inject;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.kjp.keeprun.persistence.BoardDAO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO boardDAO;
	
			
	@Override
	public WorkProcessVO lastWork(int deviceId) {
		
		return boardDAO.lastWork(deviceId);
	}
			
	@Override
	public List<WorkProcessVO> wList(int deviceId) {
		
		return boardDAO.wList(deviceId);
	}

	@Override
	public List<Integer> weekKcal(WorkProcessVO oneVO) {
		
		return boardDAO.weekKcal(oneVO);
	}

	@Override
	public List<DeviceDataVO> dayDeviceData(WorkProcessVO oneVO) {
		// TODO Auto-generated method stub
	
		return boardDAO.dayDeviceData(oneVO);
	}



	
}
