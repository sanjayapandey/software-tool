package com.und.softwartool.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwartool.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	public Project findById(long id);
	public Project findByName(String name);
	public Project save(Project project);
	public void delete(Project project);
	public List<Project> findAll();
}