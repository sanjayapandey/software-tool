package com.und.softwaretool.service;

import java.util.List;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.RCAF;

public interface RCAFService {
	public RCAF findById(long id);
	public List<RCAF> findByProject(Project project);
	public RCAF save(RCAF rcaf);
	public RCAF getRCAF(Project project);
}
