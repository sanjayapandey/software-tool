package com.und.softwartool.service;

import java.util.List;

import com.und.softwartool.model.Project;

public interface ProjectService {
	public Project findById(long id);
	public Project findByName(String name);
	public Project save(Project project);
	public void delete(Project project);
	public List<Project> findAll();
	public List<Project> findByStatus(boolean status);
}
