package com.und.softwaretool.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.RelationOfRequirement;

@Repository
public interface RelationOfRequirementRepository extends CrudRepository<RelationOfRequirement, Long>{
	public RelationOfRequirement getById(long id);
	public List<RelationOfRequirement> getByfunctionalReqId(long functionalReqId);
	public List<RelationOfRequirement> getByProject(Project project);
}