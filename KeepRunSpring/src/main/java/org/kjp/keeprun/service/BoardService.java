package org.kjp.keeprun.service;

import java.util.List;

import org.kjp.keeprun.domain.WorkProcessVO;

public interface BoardService {
	
	public WorkProcessVO todayWork(int deviceId);
	public List<WorkProcessVO> wList(int deviceId);
	
	
	
	

}
