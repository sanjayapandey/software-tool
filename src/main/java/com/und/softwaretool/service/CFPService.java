package com.und.softwaretool.service;

import java.util.List;

import com.und.softwaretool.model.CFP;
import com.und.softwaretool.model.Project;

public interface CFPService {
	public CFP findById(long id);
	public List<CFP> findByProject(Project project);
}
