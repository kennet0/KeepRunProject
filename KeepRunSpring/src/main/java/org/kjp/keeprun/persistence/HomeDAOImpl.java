package org.kjp.keeprun.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kjp.keeprun.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDAOImpl implements HomeDAO {
	
	@Inject
	private SqlSession session;
	static final String nameSpace = "org.mybatis.example.MemberMapper";

	@Override
	public void register(MemberVO vo) throws Exception {
		session.insert(nameSpace+".register", vo);
		
	}

	@Override
	public MemberVO userInfoById(MemberVO vo) throws Exception {
		
		return session.selectOne(nameSpace+".userInfoById", vo);
		
	}

	@Override
	public MemberVO userInfoByDeviceId(int deviceId) {
		
		return session.selectOne(nameSpace+".userInfoByDeviceId", deviceId);
	}

}
