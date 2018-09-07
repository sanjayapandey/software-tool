package com.und.softwaretool.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.und.softwaretool.model.FunctionalReq;
import com.und.softwaretool.model.NonFunctionalReq;
import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.RelationOfRequirement;
import com.und.softwaretool.model.SystemConstrain;
import com.und.softwaretool.service.FunctionalReqService;
import com.und.softwaretool.service.NonFunctionalReqService;
import com.und.softwaretool.service.ProjectService;
import com.und.softwaretool.service.RelationOfRequirementService;
import com.und.softwaretool.service.SystemConstrainService;

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
	@Autowired
	RelationOfRequirementService relationOfRequirementServiceImpl;
	
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
		List<Project> projects = projectServiceImpl.findByStatus(true);
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
		newProject.setStatus(true);
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
	public ModelAndView createProjectStep2(@ModelAttribute("project") Project project, RedirectAttributes redirectAttributes, Model model, @RequestParam(name="edit", required=false) String edit, @RequestParam(name="id", defaultValue = "0") Long nonFunctionalReqId, @RequestParam(name="projectId", defaultValue = "0") Long projectId){
		LOGGER.info("Inside ProjectController#createProjectStep2 method.");
		ModelAndView modelAndView = new ModelAndView();
		if(projectId!=0){
			project = projectServiceImpl.findById(projectId);
			modelAndView.addObject("project", project);
		}else if(project == null){
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
		LOGGER.info("Inside ProjectController#saveProjectStep2 method. newNonFunctionalReq is: {}",newNonFunctionalReq.toString());
		//save project
		boolean edit = false;
		newNonFunctionalReq.setProject(projectServiceImpl.findById(projectId));
		if(newNonFunctionalReq.getId()==0){
			long counter = 0;
			try{
			counter = nonFunctionalReqServiceImpl.findMaximumCounter(projectServiceImpl.findById(projectId));
			}catch(Exception e){
				LOGGER.error("Error is:{}",e);
			}
			newNonFunctionalReq.setCounter(counter+1);
			newNonFunctionalReq.setKey("NFR_"+newNonFunctionalReq.getCounter());
		}else{
			edit=true;
		}
		try{
			nonFunctionalReqServiceImpl.save(newNonFunctionalReq);
			if(edit){
				redirectAttributes.addFlashAttribute("success", "Non functional requirement edited successfully!");
			}else{
				redirectAttributes.addFlashAttribute("success", "Non functional requirement saved successfully!");
			}
		}catch(DataIntegrityViolationException e){
			redirectAttributes.addFlashAttribute("error", "Quality attribute should be unique!");
		}catch(Exception e1){
			LOGGER.error("Error while saving: Error is: {}",e1);
			redirectAttributes.addFlashAttribute("error", "Error while saving non functional requirement!");
		}
		LOGGER.info("saved non functional requirement is:"+newNonFunctionalReq.toString());
		redirectAttributes.addFlashAttribute("project", newNonFunctionalReq.getProject());
		
		return "redirect:create-step-2";
	}
	
	@RequestMapping(value="/save-functional-req", method=RequestMethod.POST)
	public String saveFunctionalReq(@ModelAttribute("functionalReq") FunctionalReq newFunctionalReq, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("projectId") long projectId, @RequestParam("relatedFunctionalReq") long relatedFunctionalReqId){
		LOGGER.info("Inside ProjectController#saveFunctionalReq method.");
		//save project
		boolean isEdit = false;
		newFunctionalReq.setProject(projectServiceImpl.findById(projectId));
		
		if(newFunctionalReq.getId()==0){
			long counter = 0;
			try{
			counter = functionalReqServiceImpl.findMaximumCounter(projectServiceImpl.findById(projectId));
			}catch(Exception e){
				LOGGER.error("Error is:{}",e);
			}
			newFunctionalReq.setCounter(counter+1);
			newFunctionalReq.setKey("FR_"+newFunctionalReq.getCounter());
		}else{
			isEdit = true;
		}
		
		functionalReqServiceImpl.save(newFunctionalReq);
		LOGGER.info("saved functional requirement is:"+newFunctionalReq.toString());
		//save relation with other requirements
		RelationOfRequirement relationOfRequirement = new RelationOfRequirement();
		relationOfRequirement.setFunctionalReqId(newFunctionalReq.getId());
		relationOfRequirement.setRelatedFunctionalReqId(relatedFunctionalReqId);
		relationOfRequirement.setProject(newFunctionalReq.getProject());
		relationOfRequirementServiceImpl.save(relationOfRequirement);
		LOGGER.info("Relation with other requirement saved: {}",relationOfRequirement.toString());
		redirectAttributes.addFlashAttribute("project", newFunctionalReq.getProject());
		if(isEdit){
			redirectAttributes.addFlashAttribute("success", "Functional requirement edited successfully!");
		}else{
			redirectAttributes.addFlashAttribute("success", "Functional requirement saved successfully!");
		}
		return "redirect:create-step-2";
	}
	
	@RequestMapping(value="/save-system-constrain", method=RequestMethod.POST)
	public String saveSystemConstrain(@ModelAttribute("systemConstrain") SystemConstrain newSystemConstrain, BindingResult result, RedirectAttributes redirectAttributes, @RequestParam("projectId") long projectId){
		LOGGER.info("Inside ProjectController#saveSystemConstrain method.");
		//save project
		newSystemConstrain.setProject(projectServiceImpl.findById(projectId));
		
		long counter = 0;
		try{
		counter = systemConstrainServiceImpl.findMaximumCounter(projectServiceImpl.findById(projectId));
		}catch(Exception e){
			LOGGER.error("Error is:{}",e);
		}
		newSystemConstrain.setCounter(counter+1);
		newSystemConstrain.setKey("SC_"+newSystemConstrain.getCounter());
		
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
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public String deleteProject(@PathVariable("id") long id, ModelAndView modelAndView ){
		LOGGER.info("Inside ProjectController#deleteProject method.");
		try{
		Project project = projectServiceImpl.findById(id);
		project.setStatus(false);
		projectServiceImpl.save(project);
		}catch(Exception e){
			LOGGER.error("Error while delete. {}",e);
		}
		return "success";
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
		//create relation object
		List<RelationOfRequirement> relationOfRequirements = relationOfRequirementServiceImpl.getByProject(project);
		HashMap<Long, String> mapOfRelatedFR = new HashMap<Long, String>();
		for(RelationOfRequirement relationOfRequirement:relationOfRequirements){
			long functionalReqId = relationOfRequirement.getFunctionalReqId();
			long relatedFunReqId = relationOfRequirement.getRelatedFunctionalReqId();
			try{
			FunctionalReq functionalReq =  functionalReqServiceImpl.findById(relatedFunReqId);
			if(null != functionalReq){
				mapOfRelatedFR.put(functionalReqId, functionalReqServiceImpl.findById(relatedFunReqId).getKey());
			}
			}catch(Exception e){
				LOGGER.error("Error is:{}",e);
			}
		}
		modelAndView.addObject("mapOfRelatedFR", mapOfRelatedFR);
		modelAndView.setViewName("view");
		return modelAndView;
		
	}
	
	@RequestMapping( value="/getNonFunctionalReq/{id}", method= RequestMethod.GET)
	@ResponseBody
	public String getNonFunctionalReq(@PathVariable("id") long id){
		LOGGER.info("Inside ProjectController#getNonFunctionalReq method. Id is:{}",id);
		NonFunctionalReq nonFunctionalReq = nonFunctionalReqServiceImpl.findById(id);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(nonFunctionalReq);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping( value="/getFunctionalReq/{id}", method= RequestMethod.GET)
	@ResponseBody
	public String getFunctionalReq(@PathVariable("id") long id){
		LOGGER.info("Inside ProjectController#getFunctionalReq method. Id is:{}",id);
		FunctionalReq functionalReq = functionalReqServiceImpl.findById(id);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(functionalReq);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value="/non-functional-req/{id}", method=RequestMethod.GET)
	public ModelAndView viewNonFunctionalRequirement(@PathVariable("id") long id){
		LOGGER.info("Inside ProjectController#viewNonFunctionalRequirement method. Id is: {}",id);
		ModelAndView modelAndView = new ModelAndView();
		NonFunctionalReq nonFunctionalReq = nonFunctionalReqServiceImpl.findById(id);
		modelAndView.addObject("nonFunctionalRequirement", nonFunctionalReq);
		List<FunctionalReq> functionalReqs = functionalReqServiceImpl.findByNonFunctionalReqAndProject(nonFunctionalReq, nonFunctionalReq.getProject());
		modelAndView.addObject("functionalReqs", functionalReqs);
		HashMap<Long, String> mapOfRelatedFR = new HashMap<Long, String>();
		List<RelationOfRequirement> relationOfRequirements = relationOfRequirementServiceImpl.getByProject(nonFunctionalReq.getProject());
		for(RelationOfRequirement relationOfRequirement:relationOfRequirements){
			long functionalReqId = relationOfRequirement.getFunctionalReqId();
			long relatedFunReqId = relationOfRequirement.getRelatedFunctionalReqId();
			try{
			FunctionalReq functionalReq =  functionalReqServiceImpl.findById(relatedFunReqId);
			if(null != functionalReq){
				mapOfRelatedFR.put(functionalReqId, functionalReqServiceImpl.findById(relatedFunReqId).getKey());
			}
			}catch(Exception e){
				LOGGER.error("Error is:{}",e);
			}
		}
		modelAndView.addObject("mapOfRelatedFR", mapOfRelatedFR);
		modelAndView.setViewName("nft-details");
		return modelAndView;
	}
}
