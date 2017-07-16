package com.und.softwartool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwartool.model.FunctionalReq;
import com.und.softwartool.model.Project;
import com.und.softwartool.repository.FunctionalReqRepository;
import com.und.softwartool.service.FunctionalReqService;

@Service
public class FunctionalReqServiceImpl implements FunctionalReqService{

	private static final Logger LOGGER = LogManager.getLogger(FunctionalReqServiceImpl.class);
	
	@Autowired
	FunctionalReqRepository FunctionalReqRepository;

	
	
	public FunctionalReq findById(long id) {
		return FunctionalReqRepository.findById(id);
	}

	public List<FunctionalReq> findByProject(Project project) {
		return FunctionalReqRepository.findByProject(project);
	}

	public FunctionalReq save(FunctionalReq FunctionalReq) {
		LOGGER.info("Inside FunctionalReqServiceImpl#save method. Req is: {}",FunctionalReq.toString());
		return FunctionalReqRepository.save(FunctionalReq);
	}
	
}
