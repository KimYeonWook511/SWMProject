package com.studywithme.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String rootGET(Model model) {
		logger.info("rootGET 角青");
		
		return "main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainGET(Model model) {
		logger.info("mainGET 角青");
		
		return "main";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String rootPOST(Model model) {
		logger.info("rootPOST 角青");
		
		return "main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String mainPOST(Model model) {
		logger.info("mainPOST 角青");
		
		return "main";
	}
}
