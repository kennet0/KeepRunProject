package org.kjp.keeprun;



import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.persistence.BoardDAO;
import org.kjp.keeprun.persistence.HomeDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class DAOTest {
	@Inject
	HomeDAO homeDao;
	BoardDAO boardDao;
	
	@Test
	public void create() throws Exception{
		
		MemberVO vo = new MemberVO();
		vo.setAge(3);
		vo.setUserHeight(10);
		
		vo.setDeviceId(10);
		homeDao.register(vo);
	}
	
	@Test
	public void timeTest() throws Exception{
		
//        Date sqlDate = new java.sql.Date(System.currentTimeMillis());
//        List<Integer> list = boardDao.weekKcal(sqlDate);
        System.out.println("sdafds");
    }

	
}
