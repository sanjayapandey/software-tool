package com.und.softwartool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="relation_of_req")
public class RelationOfRequirement {
	
	@Column(name="id")
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@Column(name="functional_req_id")
	private long functionalReqId;
	
	@Column(name="related_functional_req_id")
	private long relatedFunctionalReqId;

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

	public long getFunctionalReqId() {
		return functionalReqId;
	}

	public void setFunctionalReqId(long functionalReqId) {
		this.functionalReqId = functionalReqId;
	}

	public long getRelatedFunctionalReqId() {
		return relatedFunctionalReqId;
	}

	public void setRelatedFunctionalReqId(long relatedFunctionalReqId) {
		this.relatedFunctionalReqId = relatedFunctionalReqId;
	}

	@Override
	public String toString() {
		return "RelationOfRequirement [id=" + id + ", project=" + project
				+ ", functionalReqId=" + functionalReqId
				+ ", relatedFunctionalReqId=" + relatedFunctionalReqId + "]";
	}

	
}
