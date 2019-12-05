package org.kjp.keeprun.persistence;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	static final String nameSpace = "org.mybatis.example.boardMapper";

	
	@Override
	public WorkProcessVO todayWork(int deviceId) {
		// TODO Auto-generated method stub
		return session.selectOne(nameSpace+ ".todayWork",deviceId);
	}
	
	@Override
	public List<WorkProcessVO> wList(int deviceId) {
		System.out.println("BoardDAO wList");
		
		return session.selectList(nameSpace+".wList", deviceId);
	}

	@Override
	public List<Integer> weekKcal(Date workDate) {
		
		return session.selectList(nameSpace+".weekKcal", workDate);
	}

	@Override
	public List<DeviceDataVO> dayDeviceData(Date sendTime) {
		
		return session.selectList(nameSpace+".dayDeviceData", sendTime);
	}

	

}
