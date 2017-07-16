package com.und.softwartool.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.und.softwartool.model.NonFunctionalReq;
import com.und.softwartool.model.Project;
import com.und.softwartool.service.NonFunctionalReqService;
import com.und.softwartool.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	private static final Logger LOGGER = LogManager.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectServiceImpl;
	
	@Autowired
	NonFunctionalReqService nonFunctionalReqServiceImpl;
	
	@RequestMapping( value="list", method= RequestMethod.GET)
	public ModelAndView showProjects(){
		LOGGER.info("Inside ProjectController#showProjects method.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("projects");
		return modelAndView;
		
	}
	@RequestMapping( value="/create-step-1", method= RequestMethod.GET)
	public ModelAndView createProjectStep1(){
		LOGGER.info("Inside ProjectController#createProjectStep1 method.");
		ModelAndView modelAndView = new ModelAndView();
		Project project = new Project();
		modelAndView.addObject("project", project);
		modelAndView.setViewName("create-project1");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/save-step-1", method=RequestMethod.POST)
	public String saveProjectStep1(@ModelAttribute("project") Project newProject, BindingResult result, RedirectAttributes redirectAttributes){
		LOGGER.info("Inside ProjectController#saveProjectStep1 method.");
		LOGGER.info("Project name is: "+newProject.getName());
		//save project
		projectServiceImpl.save(newProject);
		LOGGER.info("saved project is:"+newProject.toString());
		redirectAttributes.addFlashAttribute("project", newProject);
		redirectAttributes.addFlashAttribute("success", "Project created successfully!");
		return "redirect:create-step-2";
		
	}
	
	@RequestMapping( value="/create-step-2", method= RequestMethod.GET)
	public ModelAndView createProjectStep2(@ModelAttribute("project") Project project, RedirectAttributes redirectAttributes, Model model){
		LOGGER.info("Inside ProjectController#createProjectStep2 method.");
		ModelAndView modelAndView = new ModelAndView();
		if(project == null){
			project = new Project();
			modelAndView.addObject("project", project);
			modelAndView.setViewName("create-project1");
			return modelAndView;
		}
		NonFunctionalReq nonFunctionalReq = new NonFunctionalReq();
		nonFunctionalReq.setProject(project);
		List<NonFunctionalReq> nonFunctionalReqs = nonFunctionalReqServiceImpl.findByProject(project);
		modelAndView.addObject("nonFunctionalReq", nonFunctionalReq);
		modelAndView.addObject("nonFunctionalReqs", nonFunctionalReqs);
		modelAndView.setViewName("create-project2");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/save-step-2", method=RequestMethod.POST)
	public String saveProjectStep2(@ModelAttribute("nonFunctionalReq") NonFunctionalReq newNonFunctionalReq, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("projectId") long projectId){
		LOGGER.info("Inside ProjectController#saveProjectStep2 method.");
		//save project
		newNonFunctionalReq.setProject(projectServiceImpl.findById(projectId));
		nonFunctionalReqServiceImpl.save(newNonFunctionalReq);
		LOGGER.info("saved non functional requirement is:"+newNonFunctionalReq.toString());
		redirectAttributes.addFlashAttribute("project", newNonFunctionalReq.getProject());
		redirectAttributes.addFlashAttribute("success", "Non functional requirement saved successfully!");
		return "redirect:create-step-2";
	}
	
	@RequestMapping( value="/view/{id}", method= RequestMethod.GET)
	public ModelAndView viewProject(@RequestParam("id") long id){
		LOGGER.info("Inside ProjectController#viewProject method.");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view");
		return modelAndView;
		
	}
}
