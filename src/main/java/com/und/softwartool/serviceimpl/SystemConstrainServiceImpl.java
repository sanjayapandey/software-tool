package com.und.softwartool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwartool.model.Project;
import com.und.softwartool.model.SystemConstrain;
import com.und.softwartool.repository.SystemConstrainRepository;
import com.und.softwartool.service.SystemConstrainService;

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
	
}
