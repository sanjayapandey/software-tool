package com.und.softwaretool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwaretool.model.NonFunctionalReq;
import com.und.softwaretool.model.Project;
import com.und.softwaretool.repository.NonFunctionalReqRepository;
import com.und.softwaretool.service.NonFunctionalReqService;

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

	public NonFunctionalReq save(NonFunctionalReq nonFunctionalReq) throws ConstraintViolationException  {
		LOGGER.info("Inside NonFunctionalReqServiceImpl#save method. Req is: {}",nonFunctionalReq.toString());
		return nonFunctionalReqRepository.save(nonFunctionalReq);
	}

	public long findMaximumCounter(Project project) {
		return nonFunctionalReqRepository.findMaximumCounter(project);
	}
	
}
