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
		logger.info("SWMProject Start");
		
		return "main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainGET(Model model) {
		logger.info("SWMProject Start");
		
		return "main";
	}
	
	@RequestMapping(value = "/t1", method = RequestMethod.GET)
	public String t1GET(Model model) {
		logger.info("SWMProject Start");
		
		return "main";
	}
}
