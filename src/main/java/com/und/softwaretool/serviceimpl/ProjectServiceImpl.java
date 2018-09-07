package com.und.softwaretool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.repository.ProjectRepository;
import com.und.softwaretool.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	private static final Logger LOGGER = LogManager.getLogger(ProjectServiceImpl.class);
	
	@Autowired
	ProjectRepository projectRepository;
	public Project findById(long id) {
		LOGGER.info("Inside ProjectSericeImpl#findById method.");
		return projectRepository.findById(id);
	}

	public Project findByName(String name) {
		LOGGER.info("Inside ProjectServiceImpl#findByName method.");
		return projectRepository.findByName(name);
	}

	public Project save(Project project) {
		LOGGER.info("Inside ProjectServiceImpl#save method.");
		return projectRepository.save(project);
	}

	public void delete(Project project) {
		LOGGER.info("Inside ProjectServiceImpl#delete method.");
		projectRepository.delete(project);
	}

	public List<Project> findAll() {
		LOGGER.info("Inside ProjectServiceImpl#findAll method.");
		return projectRepository.findAll();
	}

	public List<Project> findByStatus(boolean status) {
		return projectRepository.findByStatus(status);
	}

}
