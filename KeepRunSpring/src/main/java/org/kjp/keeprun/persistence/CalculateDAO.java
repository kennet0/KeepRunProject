package org.kjp.keeprun.persistence;

import java.util.List;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;

public interface CalculateDAO {
	

	public int calWorkTime(int deviceId);
	public int calDistance(int deviceId);
	public int calAvgHR(int deviceId);
	public void insertDayWorkProcess(WorkProcessVO workProcessVO);
	

}
