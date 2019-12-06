package org.kjp.keeprun.service;

import javax.inject.Inject;

import org.kjp.keeprun.controller.HomeController;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.persistence.HomeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService{

	@Inject
	HomeDAO dao;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}

	@Override
	public MemberVO userInfo(MemberVO vo) throws Exception {
			
		return dao.userInfo(vo);
	}

}
