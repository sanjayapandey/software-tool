package com.und.softwartool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	private static final Logger LOGGER = LogManager.getLogger(DashboardController.class);
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView showDashboard(){
		LOGGER.info("Inside DashboardController#showDashboard method.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("dashboard");
		return modelAndView;
		
	}
}
