package com.und.softwaretool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.SystemConstrain;
import com.und.softwaretool.repository.SystemConstrainRepository;
import com.und.softwaretool.service.SystemConstrainService;

@Service
public class SystemConstrainServiceImpl implements SystemConstrainService{

	private static final Logger LOGGER = LogManager.getLogger(SystemConstrainServiceImpl.class);
	
	@Autowired
	SystemConstrainRepository systemConstrainRepository;

	
	
	public SystemConstrain findById(long id) {
		return systemConstrainRepository.findById(id);
	}

	public List<SystemConstrain> findByProject(Project project) {
		return systemConstrainRepository.findByProject(project);
	}

	public SystemConstrain save(SystemConstrain systemConstrain) {
		LOGGER.info("Inside SystemConstrainServiceImpl#save method. Req is: {}",systemConstrain.toString());
		return systemConstrainRepository.save(systemConstrain);
	}

	public long findMaximumCounter(Project project) {
		return systemConstrainRepository.findMaximumCounter(project);
	}
	
}
