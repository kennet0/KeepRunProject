package org.kjp.keeprun.controller;



import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.kjp.keeprun.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

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
	public void index(HttpServletRequest request, Model model ) {
		logger.info("BoardIndex");
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        MemberVO userInfo = (MemberVO) flashMap.get("userInfo");
		
		model.addAttribute("lastWork", boardService.lastWork(userInfo.getDeviceId()));
		model.addAttribute("wList", boardService.wList(userInfo.getDeviceId()));
		model.addAttribute("weekKcal", boardService.weekKcal(boardService.lastWork(userInfo.getDeviceId())));
		model.addAttribute("dayDeviceData", boardService.dayDeviceData(boardService.lastWork(userInfo.getDeviceId())));
		
	
		
	}
	@RequestMapping(value = "/indexOne")
	public String indexOne(Model model, WorkProcessVO workProcessVO) {
	
		model.addAttribute("lastWork", boardService.lastWork(workProcessVO.getDeviceId()));
		model.addAttribute("weekKcal", boardService.weekKcal(boardService.lastWork(workProcessVO.getDeviceId())));
		
		return "board/index";
	}
	
	
	@RequestMapping(value = "/tables")
	public void table(Model model, int deviceId) {
		logger.info("BoardTables");
		
		model.addAttribute("wList", boardService.wList(deviceId));
		
	}

	
	
}
