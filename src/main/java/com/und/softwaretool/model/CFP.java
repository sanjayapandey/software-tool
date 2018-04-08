package com.und.softwaretool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cfp")
public class CFP {
	@Column(name="id")
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@Column(name="external_inputs")
	private long eiId;
	
	@Column(name="external_outputs")
	private long eoId;
	
	@Column(name="external_queries")
	private long eqId;
	
	@Column(name="internal_logic_files")
	private long ilfId;
	
	@Column(name="external_interface_files")
	private long eifId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getEiId() {
		return eiId;
	}

	public void setEiId(long eiId) {
		this.eiId = eiId;
	}

	public long getEoId() {
		return eoId;
	}

	public void setEoId(long eoId) {
		this.eoId = eoId;
	}

	public long getEqId() {
		return eqId;
	}

	public void setEqId(long eqId) {
		this.eqId = eqId;
	}

	public long getIlfId() {
		return ilfId;
	}

	public void setIlfId(long ilfId) {
		this.ilfId = ilfId;
	}

	public long getEifId() {
		return eifId;
	}

	public void setEifId(long eifId) {
		this.eifId = eifId;
	}
	
	
}
