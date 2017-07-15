package com.und.softwartool.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwartool.model.NonFunctionalReq;
import com.und.softwartool.model.Project;

@Repository
public interface NonFunctionalReqRepository extends CrudRepository<NonFunctionalReq, Long>{
	public NonFunctionalReq findById(long id);
	public List<NonFunctionalReq> findByProject(Project project);
}