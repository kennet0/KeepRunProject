package org.kjp.keeprun.controller;



import javax.inject.Inject;

import org.kjp.keeprun.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("todayWork", boardService.todayWork(deviceId));
		model.addAttribute("wList", boardService.wList(deviceId));
		
	}
	@RequestMapping(value = "/indexOne")
	public void indexOne(Model model, @RequestParam("deviceId") int deviceId) {
		logger.info("BoardIndex");
		model.addAttribute("todayWork", boardService.todayWork(deviceId));
		model.addAttribute("wList", boardService.wList(deviceId));
	}
	
	
	@RequestMapping(value = "/tables")
	public void table(Model model, @RequestParam("deviceId") int deviceId) {
		logger.info("BoardTables");
		model.addAttribute("wList", boardService.wList(deviceId));
		
	}

	
	
}
