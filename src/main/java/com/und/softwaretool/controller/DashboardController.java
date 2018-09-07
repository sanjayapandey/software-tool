package com.und.softwaretool.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.service.ProjectService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	private static final Logger LOGGER = LogManager.getLogger(DashboardController.class);
	
	@Autowired
	ProjectService projectServiceImpl;
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView showDashboard(){
		LOGGER.info("Inside DashboardController#showDashboard method.");
		ModelAndView modelAndView = new ModelAndView();
		List<Project> projects = projectServiceImpl.findByStatus(true);
		modelAndView.addObject("projects", projects);
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}
}
