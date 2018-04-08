package com.und.softwaretool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.service.ProjectService;

@Controller
@RequestMapping("/cost-estimate")
public class CostController {
	private static final Logger LOGGER = LogManager.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectServiceImpl;
	
	@RequestMapping( value="/{id}", method= RequestMethod.GET)
	public ModelAndView estimateCost(@PathVariable("id") long id){
		LOGGER.info("Inside CostController#estimateCost method. Id is:{}",id);
		ModelAndView modelAndView = new ModelAndView();
		Project project = projectServiceImpl.findById(id);
		modelAndView.addObject("project",project);

		modelAndView.setViewName("cost-estimation");
		return modelAndView;
	} 
}
