package com.und.softwartool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.und.softwartool.model.Project;
import com.und.softwartool.service.ProjectService;

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
		modelAndView.setViewName("dashboard");
		Project project = new Project();
		project.setId(1);
		project.setName("Hellp Project");
		projectServiceImpl.save(project);
		
		return modelAndView;
		
	}
}
