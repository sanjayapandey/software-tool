package com.und.softwaretool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="system_constrain")
public class SystemConstrain {
	
	@Column(name="id")
	@Id @GeneratedValue
	private long id;
	
	@Column(name="reference_key")
	private String key;
	
	@Column(name="counter")
	private long counter;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	@Column(name="software_requirement")
	private String softwareRequirement;
	
	@Column(name="hardware_requirement")
	private String hardwareRequirement;
	
	@Column(name="network_requirement")
	private String networkRequirement;
	
	
	@Column(name="other_requirement")
	private String otherRequirement;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public long getCounter() {
		return counter;
	}


	public void setCounter(long counter) {
		this.counter = counter;
	}

	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public String getSoftwareRequirement() {
		return softwareRequirement;
	}


	public void setSoftwareRequirement(String softwareRequirement) {
		this.softwareRequirement = softwareRequirement;
	}


	public String getHardwareRequirement() {
		return hardwareRequirement;
	}


	public void setHardwareRequirement(String hardwareRequirement) {
		this.hardwareRequirement = hardwareRequirement;
	}


	public String getNetworkRequirement() {
		return networkRequirement;
	}


	public void setNetworkRequirement(String networkRequirement) {
		this.networkRequirement = networkRequirement;
	}


	public String getOtherRequirement() {
		return otherRequirement;
	}


	public void setOtherRequirement(String otherRequirement) {
		this.otherRequirement = otherRequirement;
	}


	@Override
	public String toString() {
		return "SystemConstrain [id=" + id + ", project=" + project
				+ ", softwareRequirement=" + softwareRequirement
				+ ", hardwareRequirement=" + hardwareRequirement
				+ ", networkRequirement=" + networkRequirement
				+ ", otherRequirement=" + otherRequirement + "]";
	}
	
}
