package com.und.softwaretool.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import com.und.softwaretool.model.NonFunctionalReq;
import com.und.softwaretool.model.Project;

public interface NonFunctionalReqService {
	public NonFunctionalReq findById(long id);
	public List<NonFunctionalReq> findByProject(Project project);
	public NonFunctionalReq save (NonFunctionalReq nonFunctionalReq) throws ConstraintViolationException ;
	public long findMaximumCounter(Project project);
}
