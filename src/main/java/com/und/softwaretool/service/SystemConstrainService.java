package com.und.softwaretool.service;

import java.util.List;

import com.und.softwaretool.model.Project;
import com.und.softwaretool.model.SystemConstrain;

public interface SystemConstrainService {
	public SystemConstrain findById(long id);
	public List<SystemConstrain> findByProject(Project project);
	public SystemConstrain save(SystemConstrain systemConstrain);
	public long findMaximumCounter(Project project);
}
