package com.und.softwartool.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwartool.model.Project;
import com.und.softwartool.model.SystemConstrain;

@Repository
public interface SystemConstrainRepository extends CrudRepository<SystemConstrain, Long>{
	public SystemConstrain findById(long id);
	public List<SystemConstrain> findByProject(Project project);
}