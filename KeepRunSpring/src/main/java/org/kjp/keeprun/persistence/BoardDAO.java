package org.kjp.keeprun.persistence;

import java.util.List;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.TempVO;
import org.kjp.keeprun.domain.WorkProcessVO;

public interface BoardDAO {
	
	public WorkProcessVO dayWorkProcessData(TempVO vo);
	public List<WorkProcessVO> wList(int deviceId);
	public List<Integer> weekKcal(WorkProcessVO oneVO);
	public List<DeviceDataVO> dayDeviceData(WorkProcessVO oneVO);

}

