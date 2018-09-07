package com.und.softwaretool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwaretool.model.FunctionalReq;
import com.und.softwaretool.model.NonFunctionalReq;
import com.und.softwaretool.model.Project;
import com.und.softwaretool.repository.FunctionalReqRepository;
import com.und.softwaretool.service.FunctionalReqService;

@Service
public class FunctionalReqServiceImpl implements FunctionalReqService{

	private static final Logger LOGGER = LogManager.getLogger(FunctionalReqServiceImpl.class);
	
	@Autowired
	FunctionalReqRepository functionalReqRepository;

	
	
	public FunctionalReq findById(long id) {
		return functionalReqRepository.findById(id);
	}

	public List<FunctionalReq> findByProject(Project project) {
		return functionalReqRepository.findByProject(project);
	}

	public FunctionalReq save(FunctionalReq FunctionalReq) {
		LOGGER.info("Inside FunctionalReqServiceImpl#save method. Req is: {}",FunctionalReq.toString());
		return functionalReqRepository.save(FunctionalReq);
	}

	public long findMaximumCounter(Project project) {
		return functionalReqRepository.findMaximumCounter(project);
	}

	public List<FunctionalReq> findByNonFunctionalReqAndProject(
			NonFunctionalReq nonFunctionalReq, Project project) {
		return functionalReqRepository.findByNonFunctionalReqAndProject(nonFunctionalReq, project);
	}
	
}
