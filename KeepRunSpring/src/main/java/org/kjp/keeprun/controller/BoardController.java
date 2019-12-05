package org.kjp.keeprun.controller;



import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.kjp.keeprun.domain.WorkProcessVO;
import org.kjp.keeprun.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@RequestMapping(value = "/index")
	public void index(Model model, @RequestParam("deviceId") int deviceId) {
		logger.info("BoardIndex");
		// 3. sql.Date를 이용하여 얻어온 Date
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        
        logger.info(format.format(sqlDate));

		model.addAttribute("todayWork", boardService.todayWork(deviceId));
		model.addAttribute("wList", boardService.wList(deviceId));
		model.addAttribute("weekKcal", boardService.weekKcal(sqlDate));
		
	}
	@RequestMapping(value = "/indexOne")
	public String indexOne(Model model, WorkProcessVO workProcessVO) {
		logger.info("BoardIndex");
		model.addAttribute("todayWork", boardService.todayWork(workProcessVO.getDeviceId()));
		
		model.addAttribute("weekKcal", boardService.weekKcal(workProcessVO.getWorkDate()));
		
		return "board/index";
	}
	
	
	@RequestMapping(value = "/tables")
	public void table(Model model, @RequestParam("deviceId") int deviceId) {
		logger.info("BoardTables");
		model.addAttribute("wList", boardService.wList(deviceId));
		
	}

	
	
}
