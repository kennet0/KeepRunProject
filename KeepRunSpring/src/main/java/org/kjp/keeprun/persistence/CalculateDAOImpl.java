package org.kjp.keeprun.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class CalculateDAOImpl implements CalculateDAO {
	
	@Inject
	private SqlSession session;
	static final String nameSpace = "org.mybatis.example.calculateMapper";

	@Override
	public List<DeviceDataVO> dailyDeviceData(int deviceId) {
		
		return session.selectOne(nameSpace+ ".lastWork",deviceId);
	}

}
