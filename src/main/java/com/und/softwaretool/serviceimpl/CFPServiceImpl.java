package com.und.softwaretool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwaretool.model.CFP;
import com.und.softwaretool.model.Project;
import com.und.softwaretool.repository.CFPRepositoty;
import com.und.softwaretool.service.CFPService;

@Service
public class CFPServiceImpl implements CFPService{

	private static final Logger LOGGER = LogManager.getLogger(CFPServiceImpl.class);
	
	@Autowired
	CFPRepositoty cfpRepositoty;

	public CFP findById(long id) {
		LOGGER.info("Inside CFPServiceImpl#findById id {}",id);
		return cfpRepositoty.findById(id);
	}

	public List<CFP> findByProject(Project project) {
		LOGGER.info("Inside CFPServiceImpl#findByProject method.");
		return cfpRepositoty.findByProject(project);
	}
	public CFP getCFP(Project project) {
		List<CFP> cfps = cfpRepositoty.findByProject(project);
		if(cfps!=null && cfps.size()>0) {
			return cfps.get(0);
		}else {
			return null;
		}
	}

	public CFP save(CFP cfp) {
		return cfpRepositoty.save(cfp);
	}
}
