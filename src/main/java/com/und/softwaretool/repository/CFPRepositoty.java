package com.und.softwaretool.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwaretool.model.CFP;
import com.und.softwaretool.model.Project;

@Repository
public interface CFPRepositoty extends CrudRepository<CFP, Long>{
	public CFP findById(long id);
	public List<CFP> findByProject(Project project);
}