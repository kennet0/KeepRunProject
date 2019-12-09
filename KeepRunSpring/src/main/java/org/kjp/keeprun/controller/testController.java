package org.kjp.keeprun.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import org.kjp.keeprun.domain.DeviceDataVO;
import org.kjp.keeprun.persistence.BoardDAO;
import org.kjp.keeprun.persistence.DataDAO;
import org.kjp.keeprun.service.BoardService;
import org.kjp.keeprun.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
	@Inject
	BoardDAO boardDao;
	@Inject
	BoardService boardService;
	@Inject
	DataService calculateService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(testController.class);
	
	@RequestMapping(value = "/test")
	public void test() {
	
    }
   

}
