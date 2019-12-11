package org.kjp.keeprun.controller;



import java.sql.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.domain.WorkProcessVO;
import org.kjp.keeprun.service.BoardService;
import org.kjp.keeprun.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService boardService;
	@Inject
	HomeService homeService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@RequestMapping(value = "/index")
	public void index(int deviceId, Model model, HttpServletRequest request,MemberVO userInfoJsp) throws Exception {
		logger.info("BoardIndex");
		if(userInfoJsp.getUserCurrentWeight()!=0) {
			homeService.updatePieWeight(userInfoJsp);
		}
		     
        if(!boardService.wList(deviceId).toString().equals("[]")) {
	        Date lastWorkDate = boardService.wList(deviceId).get(0).getWorkDate();
	       	model.addAttribute("dayWorkProcessData", boardService.dayWorkProcessData(deviceId,lastWorkDate));
			model.addAttribute("weekKcal", boardService.weekKcal(boardService.dayWorkProcessData(deviceId,lastWorkDate)));
			model.addAttribute("dayDeviceData", boardService.dayDeviceData(boardService.dayWorkProcessData(deviceId,lastWorkDate)));
        }
        model.addAttribute("userInfo", homeService.userInfoByDeviceId(deviceId)); 
	
		
	}
	@RequestMapping(value = "/indexOne")
	public String indexOne(Model model, WorkProcessVO workProcessVO) throws Exception {
			
		model.addAttribute("dayWorkProcessData", boardService.dayWorkProcessData(workProcessVO.getDeviceId(),workProcessVO.getWorkDate()));
		model.addAttribute("weekKcal", boardService.weekKcal(boardService.dayWorkProcessData(workProcessVO.getDeviceId(),workProcessVO.getWorkDate())));
		model.addAttribute("dayDeviceData", boardService.dayDeviceData(boardService.dayWorkProcessData(workProcessVO.getDeviceId(),workProcessVO.getWorkDate())));
		model.addAttribute("userInfo", homeService.userInfoByDeviceId(workProcessVO.getDeviceId()));
		
	
		return "board/index";
	}
	
	
	@RequestMapping(value = "/tables")
	public void table(Model model, int deviceId) throws Exception {
		logger.info("BoardTables");
		
		model.addAttribute("userInfo", homeService.userInfoByDeviceId(deviceId)); 
		model.addAttribute("wList", boardService.wList(deviceId));
		
	}

	
	
}
