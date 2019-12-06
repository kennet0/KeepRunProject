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
@RequestMapping("/login/*")
public class FrontController {
	
	@Inject
	HomeService homeService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/index")
	public void index() {
		logger.info("index");
	
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public void register() {
		logger.info("register");
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String registerPost(MemberVO vo) throws Exception{
		logger.info("registerPost");
		
		if(homeService.userInfo(vo)==null) { //Áßº¹¾ÈµÆ´Ù
			logger.info("ok");
			homeService.register(vo);
						
		}else {
			return "404";
		}
		
		return "redirect:/";
			
	}
		
	
}
