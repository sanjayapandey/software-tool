package com.und.softwaretool.service;

import java.util.List;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.RelationOfRequirement;

public interface RelationOfRequirementService {
	public RelationOfRequirement getById(long id);
	public List<RelationOfRequirement> getByfunctionalReqId(long functionalReqId);
	public RelationOfRequirement save(RelationOfRequirement relationOfRequirement);
	public List<RelationOfRequirement> getByProject(Project project);
}
