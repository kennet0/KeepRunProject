package org.kjp.keeprun.persistence;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAOImpl implements DataDAO {
	
	@Inject
	private SqlSession session;
	static final String nameSpace = "org.mybatis.example.dataMapper";

	@Override
	public void insertA_data(DeviceDataVO deviceDataVO) {
		session.insert(nameSpace + ".a_dataInsert", deviceDataVO);
		
	}
	
		
}
	
	
	


