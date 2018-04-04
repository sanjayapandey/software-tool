package com.und.softwaretool.service;

import java.util.List;

import com.und.softwaretool.model.FunctionalReq;
import com.und.softwaretool.model.NonFunctionalReq;
import com.und.softwaretool.model.Project;

public interface FunctionalReqService {
	public FunctionalReq findById(long id);
	public List<FunctionalReq> findByProject(Project project);
	public FunctionalReq save(FunctionalReq FunctionalReq);
	public long findMaximumCounter(Project project);
	public List<FunctionalReq> findByNonFunctionalReqAndProject(NonFunctionalReq nonFunctionalReq, Project project);
}
