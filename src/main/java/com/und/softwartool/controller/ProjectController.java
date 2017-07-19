package com.und.softwartool.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.und.softwartool.model.FunctionalReq;
import com.und.softwartool.model.NonFunctionalReq;
import com.und.softwartool.model.Project;
import com.und.softwartool.model.SystemConstrain;
import com.und.softwartool.service.FunctionalReqService;
import com.und.softwartool.service.NonFunctionalReqService;
import com.und.softwartool.service.ProjectService;
import com.und.softwartool.service.SystemConstrainService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	private static final Logger LOGGER = LogManager.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectServiceImpl;
	
	@Autowired
	NonFunctionalReqService nonFunctionalReqServiceImpl;
	@Autowired
	FunctionalReqService functionalReqServiceImpl;
	@Autowired
	SystemConstrainService systemConstrainServiceImpl;
	
	
	/**
     * controller binder
     * 
     * @param request
     * @param binder
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {

        // business
        binder.registerCustomEditor(NonFunctionalReq.class, new PropertyEditorSupport() {

            // Converts a String ID to a nonFunctionalReq (when submitting form)
            @Override
            public void setAsText(String id) {
                if (id == null) {
                    throw new RuntimeException();
                }
                NonFunctionalReq nonFunctionalReq = nonFunctionalReqServiceImpl.findById(new Long((String) id));
                if (nonFunctionalReq == null) {
                    throw new RuntimeException();
                }
                this.setValue(nonFunctionalReq);
            }
        });
    }
	
	
	@RequestMapping( value="/list", method= RequestMethod.GET)
	public ModelAndView showProjects(){
		LOGGER.info("Inside ProjectController#showProjects method.");
		ModelAndView modelAndView = new ModelAndView();
		List<Project> projects = projectServiceImpl.findAll();
		modelAndView.addObject("projects", projects);
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
		LOGGER.info("Inside ProjectController#saveProjectStep1 method. Project is:{}", newProject.toString());
		long id = newProject.getId();
		//save project
		projectServiceImpl.save(newProject);
		LOGGER.info("saved project is:"+newProject.toString());
		redirectAttributes.addFlashAttribute("project", newProject);
		if(id==0){
			redirectAttributes.addFlashAttribute("success", "Project created successfully!");
		}else{
			redirectAttributes.addFlashAttribute("success", "Project edited successfully!");
		}
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
		//for Non functional requirement
		NonFunctionalReq nonFunctionalReq = new NonFunctionalReq();
		nonFunctionalReq.setProject(project);
		List<NonFunctionalReq> nonFunctionalReqs = nonFunctionalReqServiceImpl.findByProject(project);
		modelAndView.addObject("nonFunctionalReq", nonFunctionalReq);
		modelAndView.addObject("nonFunctionalReqs", nonFunctionalReqs);
		
		//for functional requirement
		FunctionalReq functionalReq = new FunctionalReq();
		functionalReq.setProject(project);
		List<FunctionalReq> functionalReqs = functionalReqServiceImpl.findByProject(project);
		modelAndView.addObject("functionalReq", functionalReq);
		modelAndView.addObject("functionalReqs", functionalReqs);
		
		//for system constraints
		SystemConstrain systemConstrain = new SystemConstrain();
		systemConstrain.setProject(project);
		List<SystemConstrain> systemConstrains = systemConstrainServiceImpl.findByProject(project);
		modelAndView.addObject("systemConstrain", systemConstrain);
		modelAndView.addObject("systemConstrains", systemConstrains);
		
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
	
	@RequestMapping(value="/save-functional-req", method=RequestMethod.POST)
	public String saveFunctionalReq(@ModelAttribute("functionalReq") FunctionalReq newFunctionalReq, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("projectId") long projectId){
		LOGGER.info("Inside ProjectController#saveFunctionalReq method.");
		//save project
		newFunctionalReq.setProject(projectServiceImpl.findById(projectId));
		functionalReqServiceImpl.save(newFunctionalReq);
		LOGGER.info("saved functional requirement is:"+newFunctionalReq.toString());
		redirectAttributes.addFlashAttribute("project", newFunctionalReq.getProject());
		redirectAttributes.addFlashAttribute("success", "Functional requirement saved successfully!");
		return "redirect:create-step-2";
	}
	
	@RequestMapping(value="/save-system-constrain", method=RequestMethod.POST)
	public String saveSystemConstrain(@ModelAttribute("systemConstrain") SystemConstrain newSystemConstrain, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("projectId") long projectId){
		LOGGER.info("Inside ProjectController#saveSystemConstrain method.");
		//save project
		newSystemConstrain.setProject(projectServiceImpl.findById(projectId));
		systemConstrainServiceImpl.save(newSystemConstrain);
		LOGGER.info("saved system constrain is:"+newSystemConstrain.toString());
		redirectAttributes.addFlashAttribute("project", newSystemConstrain.getProject());
		redirectAttributes.addFlashAttribute("success", "System Constrain saved successfully!");
		return "redirect:create-step-2";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editProject(@PathVariable("id") long id, ModelAndView modelAndView ){
		LOGGER.info("Inside ProjectController#editProject method.");
		Project project = projectServiceImpl.findById(id);
		modelAndView.addObject("project", project);
		modelAndView.setViewName("create-project1");
		return modelAndView;
	}
	
	@RequestMapping( value="/view/{id}", method= RequestMethod.GET)
	public ModelAndView viewProject(@PathVariable("id") long id){
		LOGGER.info("Inside ProjectController#viewProject method. Id is:{}",id);
		ModelAndView modelAndView = new ModelAndView();
		Project project = projectServiceImpl.findById(id);
		modelAndView.addObject("project",project);
		modelAndView.addObject("nonFunctionalReqs", nonFunctionalReqServiceImpl.findByProject(project));
		modelAndView.addObject("functionalReqs", functionalReqServiceImpl.findByProject(project));
		modelAndView.addObject("systemConstrains", systemConstrainServiceImpl.findByProject(project));
		modelAndView.setViewName("view");
		return modelAndView;
		
	}
}
