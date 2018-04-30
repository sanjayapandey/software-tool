package com.und.softwaretool.controller;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.und.softwaretool.model.CFP;
import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.RCAF;
import com.und.softwaretool.model.WeightFactor;
import com.und.softwaretool.service.CFPService;
import com.und.softwaretool.service.ProjectService;
import com.und.softwaretool.service.RCAFService;
import com.und.softwaretool.service.WeightFactorService;

@Controller
@RequestMapping("/cost-estimate")
public class CostController {
	private static final Logger LOGGER = LogManager.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectServiceImpl;
	
	@Autowired
	CFPService cfpServiceImpl;
	
	@Autowired
	RCAFService rcafServiceImpl;
	
	@Autowired
	WeightFactorService weightFactorServiceImpl;
	
	@RequestMapping( value="/{id}", method= RequestMethod.GET)
	public ModelAndView estimateCost(@PathVariable("id") long id){
		LOGGER.info("Inside CostController#estimateCost method. Id is:{}",id);
		ModelAndView modelAndView = new ModelAndView();
		Project project = projectServiceImpl.findById(id);
		modelAndView.addObject("project",project);
		CFP cfp = cfpServiceImpl.getCFP(project);
		RCAF rcaf = rcafServiceImpl.getRCAF(project);
		try {
		if(cfp==null) {
			cfp = new CFP();
			modelAndView.addObject("cfp",cfp);
			modelAndView.addObject("externalInputs",new WeightFactor());
			modelAndView.addObject("externalInterfaceFiles",new WeightFactor());
			modelAndView.addObject("externalOutputs",new WeightFactor());
			modelAndView.addObject("externalQueries",new WeightFactor());
			modelAndView.addObject("internalLogicFiles",new WeightFactor());
		}else {
			modelAndView.addObject("cfp",cfp);
			modelAndView.addObject("externalInputs",weightFactorServiceImpl.findById(cfp.getEiId()));
			modelAndView.addObject("externalInterfaceFiles",weightFactorServiceImpl.findById(cfp.getEifId()));
			modelAndView.addObject("externalOutputs",weightFactorServiceImpl.findById(cfp.getEoId()));
			modelAndView.addObject("externalQueries",weightFactorServiceImpl.findById(cfp.getEqId()));
			modelAndView.addObject("internalLogicFiles",weightFactorServiceImpl.findById(cfp.getIlfId()));
		}
		
		if(rcaf==null) {
			rcaf = new RCAF();
		}
		modelAndView.addObject("rcaf",rcaf);
		
		LinkedHashMap<Integer,String> map=new LinkedHashMap<Integer,String>(); 
		map.put(1, "Requirement for reliable backup and recovery");
		map.put(2,"Requirement for data communication");
		map.put(3,"Extent of distributed processing");
		map.put(4, "Performance Requirement");
		map.put(5,"Expected operational environment");
		map.put(6, "Extent of online data entries");
		map.put(7, "Extent of multi-screen or multi-operation online data input");
		map.put(8,"Extent of online updating of master files");
		map.put(9, "Extent of complex inputs, outputs, online queries and files");
		map.put(10, "Extent of complex data processing");
		map.put(11, "Extent that currently developed code can be designed for reuse");
		map.put(12,"Extent of conversion and installation included in the design");
		map.put(13, "Extent of multiple installations in an organization and variety of customer organizations");
		map.put(14, "Extent of change and focus on ease of use");
		
		//put grade on map
		LinkedHashMap<Integer,Integer> gradeMap=new LinkedHashMap<Integer,Integer>();
		gradeMap.put(1, rcaf.getS1());gradeMap.put(2, rcaf.getS2());gradeMap.put(3, rcaf.getS3());
		gradeMap.put(4, rcaf.getS4());gradeMap.put(5, rcaf.getS5());gradeMap.put(6, rcaf.getS6());
		gradeMap.put(7, rcaf.getS7());gradeMap.put(8, rcaf.getS8());gradeMap.put(9, rcaf.getS9());
		gradeMap.put(10, rcaf.getS10());gradeMap.put(11, rcaf.getS11());gradeMap.put(12, rcaf.getS12());
		gradeMap.put(13, rcaf.getS13());gradeMap.put(14, rcaf.getS14());
		
		modelAndView.addObject("map",map);
		modelAndView.addObject("staff",rcaf.getStaff());
		modelAndView.addObject("gradeMap",gradeMap);
		}catch(Exception e) {
			LOGGER.error("Exception:"+e.getMessage());
		}
		modelAndView.setViewName("cost-estimation");
		return modelAndView;
	} 
	
	@RequestMapping( value="/save-cfp", method= RequestMethod.POST)
	public String saveCFP(HttpServletRequest request){
		long projectId = Long.valueOf(!request.getParameter("projectId").isEmpty()?request.getParameter("projectId"):"0");
		long cfpId =  Long.valueOf(!request.getParameter("cfpId").isEmpty()?request.getParameter("cfpId"):"0");
		LOGGER.info("Inside CostController#saveCFP method. projectId is:{}, cfpId is: {}",projectId, cfpId);
		Project project = projectServiceImpl.findById(projectId);
		//save the cfp
		CFP cfp;
		if(cfpId ==0) {
			cfp = new CFP();
			cfp.setProject(project);
		}else {
			cfp = cfpServiceImpl.findById(cfpId);
		}
		//save weight factor of external inputs
		long eiId = Long.valueOf(!request.getParameter("eiId").isEmpty()?request.getParameter("eiId"):"0");
		WeightFactor externalInputs = constructWeightFactor(eiId, request.getParameter("eiSimple"),request.getParameter("eiAverage"), request.getParameter("eiComplex"));
		weightFactorServiceImpl.save(externalInputs);
		
		//save External Interface Files
		long eifId = Long.valueOf(!request.getParameter("eifId").isEmpty()?request.getParameter("eifId"):"0");
		WeightFactor externalInterfaceFiles = constructWeightFactor(eifId, request.getParameter("eifSimple"),request.getParameter("eifAverage"), request.getParameter("eifComplex"));
		weightFactorServiceImpl.save(externalInterfaceFiles);
		
		//save External Outputs
		long eoId = Long.valueOf(!request.getParameter("eoId").isEmpty()?request.getParameter("eoId"):"0");
		WeightFactor externalOutputs = constructWeightFactor(eoId, request.getParameter("eoSimple"),request.getParameter("eoAverage"), request.getParameter("eoComplex"));
		weightFactorServiceImpl.save(externalOutputs);
		
		//save External Queries
		long eqId = Long.valueOf(!request.getParameter("eqId").isEmpty()?request.getParameter("eqId"):"0");
		WeightFactor externalQueries = constructWeightFactor(eqId, request.getParameter("eqSimple"),request.getParameter("eqAverage"), request.getParameter("eqComplex"));
		weightFactorServiceImpl.save(externalQueries);
		
		//Internal Logic Files
		long ilfId = Long.valueOf(!request.getParameter("ilfId").isEmpty()?request.getParameter("ilfId"):"0");
		WeightFactor internalLogicFiles = constructWeightFactor(ilfId, request.getParameter("ilfSimple"),request.getParameter("ilfAverage"), request.getParameter("ilfComplex"));
		weightFactorServiceImpl.save(internalLogicFiles);
		
		//update cfp
		cfp.setEiId(externalInputs.getId());
		cfp.setEifId(externalInterfaceFiles.getId());
		cfp.setEoId(externalOutputs.getId());
		cfp.setEqId(externalQueries.getId());
		cfp.setIlfId(internalLogicFiles.getId());
		
		cfpServiceImpl.save(cfp);
		return "redirect:/cost-estimate/"+project.getId();
	} 
	
	@RequestMapping( value="/save-rcaf", method= RequestMethod.POST)
	public String saveRCAF(HttpServletRequest request){
		long projectId = Long.valueOf(!request.getParameter("projectId").isEmpty()?request.getParameter("projectId"):"0");
		long rcafId =  Long.valueOf(!request.getParameter("rcafId").isEmpty()?request.getParameter("rcafId"):"0");
		LOGGER.info("Inside CostController#saveRCAF method. projectId is:{}, cfpId is: {}",projectId, rcafId);
		Project project = projectServiceImpl.findById(projectId);
		//save the cfp
		RCAF rcaf;
		if(rcafId ==0) {
			rcaf = new RCAF();
			rcaf.setProject(project);
		}else {
			rcaf = rcafServiceImpl.findById(rcafId);
		}
		//set subject grade
		rcaf.setS1(Integer.valueOf(!request.getParameter("s1").isEmpty()?request.getParameter("s1"):"0"));
		rcaf.setS2(Integer.valueOf(!request.getParameter("s2").isEmpty()?request.getParameter("s2"):"0"));
		rcaf.setS3(Integer.valueOf(!request.getParameter("s3").isEmpty()?request.getParameter("s3"):"0"));
		rcaf.setS4(Integer.valueOf(!request.getParameter("s4").isEmpty()?request.getParameter("s4"):"0"));
		rcaf.setS5(Integer.valueOf(!request.getParameter("s5").isEmpty()?request.getParameter("s5"):"0"));
		rcaf.setS6(Integer.valueOf(!request.getParameter("s6").isEmpty()?request.getParameter("s6"):"0"));
		rcaf.setS7(Integer.valueOf(!request.getParameter("s7").isEmpty()?request.getParameter("s7"):"0"));
		rcaf.setS8(Integer.valueOf(!request.getParameter("s8").isEmpty()?request.getParameter("s8"):"0"));
		rcaf.setS9(Integer.valueOf(!request.getParameter("s9").isEmpty()?request.getParameter("s9"):"0"));
		rcaf.setS10(Integer.valueOf(!request.getParameter("s10").isEmpty()?request.getParameter("s10"):"0"));
		rcaf.setS11(Integer.valueOf(!request.getParameter("s11").isEmpty()?request.getParameter("s11"):"0"));
		rcaf.setS12(Integer.valueOf(!request.getParameter("s12").isEmpty()?request.getParameter("s12"):"0"));
		rcaf.setS13(Integer.valueOf(!request.getParameter("s13").isEmpty()?request.getParameter("s13"):"0"));
		rcaf.setS14(Integer.valueOf(!request.getParameter("s14").isEmpty()?request.getParameter("s14"):"0"));

		rcafServiceImpl.save(rcaf);
		return "redirect:/cost-estimate/"+project.getId();
	} 
	
	@RequestMapping( value="/save-staff", method= RequestMethod.POST)
	public String saveStaff(HttpServletRequest request){
		long projectId = Long.valueOf(!request.getParameter("projectId").isEmpty()?request.getParameter("projectId"):"0");
		long rcafId =  Long.valueOf(!request.getParameter("rcafId").isEmpty()?request.getParameter("rcafId"):"0");
		long staff =  Long.valueOf(!request.getParameter("staff").isEmpty()?request.getParameter("staff"):"0");
		LOGGER.info("Inside CostController#saveRCAF method. projectId is:{}, cfpId is: {}",projectId, staff);
		Project project = projectServiceImpl.findById(projectId);
		//save the cfp
		RCAF rcaf;
		if(rcafId ==0) {
			rcaf = new RCAF();
			rcaf.setProject(project);
		}else {
			rcaf = rcafServiceImpl.findById(rcafId);
		}
		//set subject grade
		rcaf.setStaff(Integer.valueOf(!request.getParameter("staff").isEmpty()?request.getParameter("staff"):"0"));
		System.out.println("staff:"+staff);
		rcafServiceImpl.save(rcaf);
		return "redirect:/cost-estimate/"+project.getId();
	} 
	
	/**
	 * 
	 * @param wfId
	 * @param simpleStr
	 * @param averageStr
	 * @param complexStr
	 * @return
	 */
	private WeightFactor constructWeightFactor(long wfId, String simpleStr, String averageStr, String complexStr) {
		WeightFactor wf;
		if(wfId ==0) {
			wf = new WeightFactor();
		}else {
			wf = weightFactorServiceImpl.findById(wfId);
		}
		int simple = Integer.valueOf(!simpleStr.isEmpty()?simpleStr:"0");
		int average =  Integer.valueOf(!averageStr.isEmpty()?averageStr:"0");
		int complex =  Integer.valueOf(!complexStr.isEmpty()?complexStr:"0");
		wf.setSimple(simple);
		wf.setAverage(average);
		wf.setComplex(complex);
		return wf;
	}
	
	@RequestMapping( value="/calculate/{id}", method= RequestMethod.GET)
	public ModelAndView calculateCost(@PathVariable("id") long id){
		LOGGER.info("Inside CostController#calculateCost method. Id is:{}",id);
		ModelAndView modelAndView = new ModelAndView();
		Project project = projectServiceImpl.findById(id);
		modelAndView.addObject("project",project);
		CFP cfp = cfpServiceImpl.getCFP(project);
		RCAF rcaf = rcafServiceImpl.getRCAF(project);
		
		if(cfp!=null && rcaf !=null) {
			double CFPSum = 0;
			double RCAFSum=0;
			
			//calculate CFP sum
			WeightFactor ei = weightFactorServiceImpl.findById(cfp.getEiId());
			WeightFactor eif = weightFactorServiceImpl.findById(cfp.getEifId());
			WeightFactor eo = weightFactorServiceImpl.findById(cfp.getEoId());
			WeightFactor eq = weightFactorServiceImpl.findById(cfp.getEqId());
			WeightFactor il = weightFactorServiceImpl.findById(cfp.getIlfId());
			
			CFPSum+= ei.getSimple()*3+ei.getAverage()*4+ei.getComplex()*6;
			CFPSum+= eif.getSimple()*4+eif.getAverage()*5+eif.getComplex()*7;
			CFPSum+= eo.getSimple()*7+eo.getAverage()*10+eo.getComplex()*15;
			CFPSum+= eq.getSimple()*3+eq.getAverage()*5+eq.getComplex()*7;
			CFPSum+= il.getSimple()*5+il.getAverage()*7+il.getComplex()*10;
			
			System.out.println("CFPSum is:"+CFPSum);
			
			//calculate RCAFSum
			
			RCAFSum = rcaf.getS1()+rcaf.getS2()+rcaf.getS3()+rcaf.getS4()+rcaf.getS5()+rcaf.getS6()+rcaf.getS7()+
					rcaf.getS8()+rcaf.getS9()+rcaf.getS10()+rcaf.getS11()+rcaf.getS12()+rcaf.getS13()+rcaf.getS14();
			
			System.out.println("RCAFsum is:"+RCAFSum);
			
			/*
			 * Functional Point calculation
			 * FP = Count_Total * [ 0.65 + 0.01 * Sum(RCAF)]
			 */
			double fp = CFPSum * (0.65 + 0.01 * RCAFSum);
			
			System.out.println("Functional Points of project is: "+fp);
			/*
			 * Effort = Total_Functional_Point(FP)/Productivity
			 */
			double productivity = 10;
			double effort = fp/productivity;
			
			/*
			 * Total cost = effort * average_cost_per_fp
			 */
			double totalCost = effort * 1000;
			
			/*
			 * Size(LOC) = functional Point* effort
			 */
			int size = (int) (fp*effort);
			/*
			 * Duration = Effort / number of staff
			 */
			
			int duration = rcaf.getStaff()!=0?(int) (effort/rcaf.getStaff()):0;
			System.out.println("Effort: "+effort +"Total Cost:"+totalCost);
			modelAndView.addObject("size",size);
			modelAndView.addObject("duration",duration);
			modelAndView.addObject("fp", fp);
			modelAndView.addObject("effort",effort);
			modelAndView.addObject("totalCost", totalCost);
		}
		modelAndView.setViewName("cost-calculation");
		return modelAndView;
	} 
}
