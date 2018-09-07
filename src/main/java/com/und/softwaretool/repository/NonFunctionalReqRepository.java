package com.und.softwaretool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwaretool.model.NonFunctionalReq;
import com.und.softwaretool.model.Project;

@Repository
public interface NonFunctionalReqRepository extends CrudRepository<NonFunctionalReq, Long>{
	public NonFunctionalReq findById(long id);
	public List<NonFunctionalReq> findByProject(Project project);

	public final static String QUERY = "SELECT  MAX(counter) FROM NonFunctionalReq WHERE project = ?1";
	@Query(QUERY)
	public long findMaximumCounter(Project project);
}