package com.und.softwaretool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.RelationOfRequirement;
import com.und.softwaretool.repository.RelationOfRequirementRepository;
import com.und.softwaretool.service.RelationOfRequirementService;

@Service
public class RelationOfRequirementServiceImpl implements RelationOfRequirementService{

	private static final Logger LOGGER = LogManager.getLogger(RelationOfRequirementServiceImpl.class);
	
	@Autowired
	RelationOfRequirementRepository relationOfRequirementRepository;

	public RelationOfRequirement getById(long id) {
		LOGGER.info("Inside RelationOfRequirementServiceImpl#getById method.");
		return relationOfRequirementRepository.getById(id);
	}

	public List<RelationOfRequirement> getByfunctionalReqId(long functionalReqId) {
		LOGGER.info("Inside RelationOfRequirementServiceImpl#getByfunctionalReqId method.");
		return relationOfRequirementRepository.getByfunctionalReqId(functionalReqId);
	}

	public RelationOfRequirement save(
			RelationOfRequirement relationOfRequirement) {
		LOGGER.info("Inside RelationOfRequirementServiceImpl#save method.");
		return relationOfRequirementRepository.save(relationOfRequirement);
	}

	public List<RelationOfRequirement> getByProject(Project project) {
		return relationOfRequirementRepository.getByProject(project);
	}
	
}
