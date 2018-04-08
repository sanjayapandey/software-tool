package com.und.softwaretool.serviceimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.und.softwaretool.model.WeightFactor;
import com.und.softwaretool.repository.WeightFactorRepository;
import com.und.softwaretool.service.WeightFactorService;

@Service
public class WeightFactorServiceImpl implements WeightFactorService{

	private static final Logger LOGGER = LogManager.getLogger(WeightFactorServiceImpl.class);
	
	@Autowired
	WeightFactorRepository weightFactorRepository;

	public WeightFactor findById(long id) {
		LOGGER.info("Inside WeightFactorServiceImpl#findById method. Id: {}",id);
		return weightFactorRepository.findById(id);
	}

}
