package com.und.softwaretool.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwaretool.model.CFP;
import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.RCAF;
import com.und.softwaretool.repository.RCAFRepository;
import com.und.softwaretool.service.RCAFService;

@Service
public class RCAFServiceImpl implements RCAFService{

	private static final Logger LOGGER = LogManager.getLogger(RCAFServiceImpl.class);
	
	@Autowired
	RCAFRepository rcafRepository;

	public RCAF findById(long id) {
		return rcafRepository.findById(id);
	}

	public List<RCAF> findByProject(Project project) {
		LOGGER.info("Inside RCAFServieImpl#findByProject method. Project : {}",project.toString());
		return rcafRepository.findByProject(project);
	}
	public RCAF getRCAF(Project project) {
		List<RCAF> rcafs = rcafRepository.findByProject(project);
		if(rcafs!=null && rcafs.size()>0) {
			return rcafs.get(0);
		}else {
			return null;
		}
	}
	public RCAF save(RCAF rcaf) {
		return rcafRepository.save(rcaf);
	}
}
