package com.und.softwartool.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwartool.model.FunctionalReq;
import com.und.softwartool.model.Project;

@Repository
public interface FunctionalReqRepository extends CrudRepository<FunctionalReq, Long>{
	public FunctionalReq findById(long id);
	public List<FunctionalReq> findByProject(Project project);
}