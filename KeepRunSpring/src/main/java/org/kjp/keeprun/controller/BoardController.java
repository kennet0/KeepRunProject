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
	@Inject
	HomeService homeService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@RequestMapping(value = "/index")
	public void index(HttpServletRequest request, Model model ) {
		logger.info("BoardIndex");
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        MemberVO userInfo = (MemberVO) flashMap.get("userInfo");
        int deviceId = userInfo.getDeviceId();
        Date lastWorkDate = null;
        for(WorkProcessVO i : boardService.wList(deviceId)) {
        	lastWorkDate=i.getWorkDate();
        	break;
        }
		
		model.addAttribute("dayWorkProcessData", boardService.dayWorkProcessData(deviceId,lastWorkDate));
//		model.addAttribute("wList", boardService.wList(deviceId));
		model.addAttribute("weekKcal", boardService.weekKcal(boardService.dayWorkProcessData(deviceId,lastWorkDate)));
		model.addAttribute("dayDeviceData", boardService.dayDeviceData(boardService.dayWorkProcessData(deviceId,lastWorkDate)));
		model.addAttribute("userInfo", userInfo);
	
		
	}
	@RequestMapping(value = "/indexOne")
	public String indexOne(Model model, WorkProcessVO workProcessVO) {
				
		model.addAttribute("dayWorkProcessData", boardService.dayWorkProcessData(workProcessVO.getDeviceId(),workProcessVO.getWorkDate()));
		model.addAttribute("weekKcal", boardService.weekKcal(boardService.dayWorkProcessData(workProcessVO.getDeviceId(),workProcessVO.getWorkDate())));
		model.addAttribute("dayDeviceData", boardService.dayDeviceData(boardService.dayWorkProcessData(workProcessVO.getDeviceId(),workProcessVO.getWorkDate())));
		
	
		return "board/index";
	}
	
	
	@RequestMapping(value = "/tables")
	public void table(Model model, int deviceId) {
		logger.info("BoardTables");
		
		model.addAttribute("wList", boardService.wList(deviceId));
		
	}

	
	
}
