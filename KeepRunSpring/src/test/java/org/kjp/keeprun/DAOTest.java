package org.kjp.keeprun;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.persistence.HomeDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class DAOTest {
	@Inject
	HomeDAO dao;
	
	@Test
	public void create() throws Exception{
		
		MemberVO vo = new MemberVO();
		vo.setAge(3);
		vo.setUserHeight(10);
		
		vo.setDeviceId(10);
		dao.register(vo);
		
		
	}

}
