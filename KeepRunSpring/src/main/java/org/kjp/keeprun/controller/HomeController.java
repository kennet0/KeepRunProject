package org.kjp.keeprun.controller;



import javax.inject.Inject;

import org.kjp.keeprun.domain.MemberVO;
import org.kjp.keeprun.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@Inject
	HomeService homeService;
		
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/")
	public String login() {
		logger.info("login");

		return "login/login";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.POST)
	public String loginPost(MemberVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("loginPost");
		MemberVO checkVO = homeService.loginCheck(vo);
		
		if (!checkVO.getUserId().equals(vo.getUserId())) {
			logger.info("ID가틀렸습니다");
			
		}else if (!checkVO.getUserPw().equals(vo.getUserPw())) {
			logger.info("PW가틀렸습니다");
			
		}else {
			rttr.addAttribute("deviceId", checkVO.getDeviceId());
			return "redirect:/board/index";
		}
		
		return "404";
	}
}

