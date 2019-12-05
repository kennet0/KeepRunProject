package org.kjp.keeprun.service;

import org.kjp.keeprun.domain.MemberVO;

public interface HomeService  {
	public void register(MemberVO vo) throws Exception;
	public MemberVO loginCheck(MemberVO vo) throws Exception;

}
