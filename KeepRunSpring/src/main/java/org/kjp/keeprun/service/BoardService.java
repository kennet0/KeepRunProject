package org.kjp.keeprun.service;

import java.util.List;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;

public interface BoardService {
	
	public WorkProcessVO lastWork(int deviceId);
	public List<WorkProcessVO> wList(int deviceId);
	public List<Integer> weekKcal(WorkProcessVO oneVO);
	public List<DeviceDataVO> dayDeviceData(WorkProcessVO oneVO);
	
	
	
	

}
