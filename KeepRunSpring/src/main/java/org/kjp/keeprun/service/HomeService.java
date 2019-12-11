package org.kjp.keeprun.service;

import org.kjp.keeprun.domain.MemberVO;

public interface HomeService  {
	public void register(MemberVO vo) throws Exception;
	public MemberVO userInfoById(MemberVO vo) throws Exception;
	public 	MemberVO userInfoByDeviceId(int deviceId) throws Exception;
	public void updatePieWeight(MemberVO userInfo);
}
