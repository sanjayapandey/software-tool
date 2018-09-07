package com.und.softwaretool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="non_fun_req" , uniqueConstraints={@UniqueConstraint(columnNames = {"project_id" , "qualityAttribute"})})
public class NonFunctionalReq {
	
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
	
	@Column(name="qualityAttribute")
	private String qualityAttribute;
	
	@Column(name="source")
	private String source;
	
	@Column(name="stimulus")
	private String stimulus;
	
	@Column(name="environment")
	private String environment;
	
	@Column(name="response")
	private String response;
	
	@Column(name="measure")
	private String measure;
	
	@Column(name="description")
	private String description;

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

	public String getQualityAttribute() {
		return qualityAttribute;
	}

	public void setQualityAttribute(String qualityAttribute) {
		this.qualityAttribute = qualityAttribute;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStimulus() {
		return stimulus;
	}

	public void setStimulus(String stimulus) {
		this.stimulus = stimulus;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "NonFunctionalReq [id=" + id + ", key=" + key + ", project="
				+ project + ", qualityAttribute=" + qualityAttribute
				+ ", source=" + source + ", stimulus=" + stimulus
				+ ", environment=" + environment + ", response=" + response
				+ ", measure=" + measure + ", description=" + description + "]";
	}

	}
