package com.und.softwartool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwartool.model.NonFunctionalReq;
import com.und.softwartool.model.Project;
import com.und.softwartool.repository.NonFunctionalReqRepository;
import com.und.softwartool.service.NonFunctionalReqService;

@Service
public class NonFunctionalReqServiceImpl implements NonFunctionalReqService{

	private static final Logger LOGGER = LogManager.getLogger(NonFunctionalReqServiceImpl.class);
	
	@Autowired
	NonFunctionalReqRepository nonFunctionalReqRepository;

	
	
	public NonFunctionalReq findById(long id) {
		return nonFunctionalReqRepository.findById(id);
	}

	public List<NonFunctionalReq> findByProject(Project project) {
		return nonFunctionalReqRepository.findByProject(project);
	}

	public NonFunctionalReq save(NonFunctionalReq nonFunctionalReq) {
		LOGGER.info("Inside NonFunctionalReqServiceImpl#save method. Req is: {}",nonFunctionalReq.toString());
		return nonFunctionalReqRepository.save(nonFunctionalReq);
	}
	
}
