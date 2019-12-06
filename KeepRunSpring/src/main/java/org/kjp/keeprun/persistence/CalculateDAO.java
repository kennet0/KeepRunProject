package org.kjp.keeprun.persistence;

import java.util.List;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;

public interface CalculateDAO {
	public List<DeviceDataVO> dailyDeviceData(int deviceId);

}
