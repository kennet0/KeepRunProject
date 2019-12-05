package org.kjp.keeprun.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.kjp.keeprun.domain.WorkProcessVO;

public interface BoardService {
	
	public WorkProcessVO todayWork(int deviceId);
	public List<WorkProcessVO> wList(int deviceId);
	public List<Integer> weekKcal(Date workDate);
	
	
	
	

}
