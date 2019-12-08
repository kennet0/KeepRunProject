package org.kjp.keeprun.service;

import java.sql.Date;
import java.util.List;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;

public interface BoardService {
	
	public WorkProcessVO dayWorkProcessData(int deviceId, Date lastWorkDate);
	public List<WorkProcessVO> wList(int deviceId);
	public List<Integer> weekKcal(WorkProcessVO oneVO);
	public List<DeviceDataVO> dayDeviceData(WorkProcessVO oneVO);
	
	
	
	
	

}
