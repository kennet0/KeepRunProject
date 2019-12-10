package org.kjp.keeprun.persistence;

import org.kjp.keeprun.domain.MemberVO;

public interface HomeDAO {
	
	public void register(MemberVO vo) throws Exception;
	public 	MemberVO userInfoById(MemberVO vo) throws Exception;
	public MemberVO userInfoByDeviceId(int deviceId);
	
}
