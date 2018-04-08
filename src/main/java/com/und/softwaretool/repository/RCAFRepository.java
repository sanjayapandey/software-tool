package com.und.softwaretool.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.RCAF;

@Repository
public interface RCAFRepository extends CrudRepository<RCAF, Long>{
	public RCAF findById(long id);
	public List<RCAF> findByProject(Project project);
}