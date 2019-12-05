package org.kjp.keeprun.persistence;

import java.sql.Date;
import java.util.List;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.WorkProcessVO;

public interface BoardDAO {
	
	public WorkProcessVO todayWork(int deviceId);
	public List<WorkProcessVO> wList(int deviceId);
	public List<Integer> weekKcal(Date workDate);
	public List<DeviceDataVO> dayDeviceData(Date sendTime);

}
