package com.und.softwartool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwartool.model.FunctionalReq;
import com.und.softwartool.model.NonFunctionalReq;
import com.und.softwartool.model.Project;

@Repository
public interface FunctionalReqRepository extends CrudRepository<FunctionalReq, Long>{
	public FunctionalReq findById(long id);
	public List<FunctionalReq> findByProject(Project project);
	public List<FunctionalReq> findByNonFunctionalReqAndProject(NonFunctionalReq nonFunctionalReq, Project project);
	public final static String QUERY = "SELECT  MAX(counter) FROM FunctionalReq WHERE project = ?1";
	@Query(QUERY)
	public long findMaximumCounter(Project project);
}