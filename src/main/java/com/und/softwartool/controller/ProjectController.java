package com.und.softwartool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/project")
public class ProjectController {
	private static final Logger LOGGER = LogManager.getLogger(ProjectController.class);
	@RequestMapping( value="list", method= RequestMethod.GET)
	public ModelAndView showProjects(){
		LOGGER.info("Inside ProjectController#showProjects method.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("projects");
		return modelAndView;
		
	}
	@RequestMapping( value="/create", method= RequestMethod.GET)
	public ModelAndView createProject(){
		LOGGER.info("Inside ProjectController#crateProject method.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("create-project");
		return modelAndView;
		
	}
	@RequestMapping( value="/view/{id}", method= RequestMethod.GET)
	public ModelAndView viewProject(@RequestParam("id") long id){
		LOGGER.info("Inside ProjectController#viewProject method.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view");
		return modelAndView;
		
	}
}
