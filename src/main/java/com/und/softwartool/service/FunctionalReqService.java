package com.und.softwartool.service;

import java.util.List;

import com.und.softwartool.model.FunctionalReq;
import com.und.softwartool.model.NonFunctionalReq;
import com.und.softwartool.model.Project;

public interface FunctionalReqService {
	public FunctionalReq findById(long id);
	public List<FunctionalReq> findByProject(Project project);
	public FunctionalReq save(FunctionalReq FunctionalReq);
	public long findMaximumCounter(Project project);
	public List<FunctionalReq> findByNonFunctionalReqAndProject(NonFunctionalReq nonFunctionalReq, Project project);
}
