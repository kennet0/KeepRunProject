package org.kjp.keeprun.persistence;

import java.util.List;

import org.kjp.keeprun.domain.WorkProcessVO;

public interface BoardDAO {
	
	public WorkProcessVO todayWork(int deviceId);
	public List<WorkProcessVO> wList(int deviceId);

}
