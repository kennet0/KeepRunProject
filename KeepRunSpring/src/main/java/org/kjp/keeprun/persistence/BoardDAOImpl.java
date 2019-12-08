package org.kjp.keeprun.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.TempVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	static final String nameSpace = "org.mybatis.example.boardMapper";

	
	@Override
	public WorkProcessVO dayWorkProcessData(TempVO vo) {
		// TODO Auto-generated method stub
		return session.selectOne(nameSpace+ ".dayWorkProcessData",vo);
	}
	
	@Override
	public List<WorkProcessVO> wList(int deviceId) {
		System.out.println("BoardDAO wList");
		
		return session.selectList(nameSpace+".wList", deviceId);
	}

	@Override
	public List<Integer> weekKcal(WorkProcessVO oneVO) {
		
		return session.selectList(nameSpace+".weekKcal", oneVO);
	}

	@Override
	public List<DeviceDataVO> dayDeviceData(WorkProcessVO oneVO) {
		
		return session.selectList(nameSpace+".dayDeviceData", oneVO);
	}

	
	

}
