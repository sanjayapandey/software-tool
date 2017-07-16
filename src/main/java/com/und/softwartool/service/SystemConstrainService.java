package com.und.softwartool.service;

import java.util.List;

import com.und.softwartool.model.Project;
import com.und.softwartool.model.SystemConstrain;

public interface SystemConstrainService {
	public SystemConstrain findById(long id);
	public List<SystemConstrain> findByProject(Project project);
	public SystemConstrain save(SystemConstrain systemConstrain);
}
