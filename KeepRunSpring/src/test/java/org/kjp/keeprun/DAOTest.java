package org.kjp.keeprun;



import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.persistence.BoardDAO;
import org.kjp.keeprun.persistence.HomeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})



public class DAOTest {
	@Inject
	HomeDAO homeDao;
	BoardDAO boardDao;
	private static Logger logger = LoggerFactory.getLogger(DAOTest.class);
	
	@Test
	public void create() throws Exception{
		
		MemberVO vo = new MemberVO();
	;
		vo.setUserHeight(10);
		
		vo.setDeviceId(10);
		homeDao.register(vo);
	}
	
	@Test
	public void timeTest() throws Exception{
		
//        Date sqlDate = new java.sql.Date(System.currentTimeMillis());
//        List<Integer> list = boardDao.weekKcal(sqlDate);
        logger.info("sdafds");
    }

	
}
