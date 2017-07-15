package com.und.softwartool.service;

import java.util.List;

import com.und.softwartool.model.NonFunctionalReq;
import com.und.softwartool.model.Project;

public interface NonFunctionalReqService {
	public NonFunctionalReq findById(long id);
	public List<NonFunctionalReq> findByProject(Project project);
	public NonFunctionalReq save(NonFunctionalReq nonFunctionalReq);
}
