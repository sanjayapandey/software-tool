package com.und.softwartool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fun_req")
public class FunctionalReq {
	
	@Column(name="id")
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@Column(name="name")
	private String name;
	
	@Column(name="prerequisites")
	private String prerequisites;
	
	@Column(name="reference_link")
	private String references;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="nonFunctionalReq_id")
	private NonFunctionalReq nonFunctionalReq;
	
	@Column(name="ref_to_fun_req_id")
	private long reference_id;
	
	@Column(name="type_of_req")
	private String typeOfReq;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getReferences() {
		return references;
	}

	public void setReferences(String references) {
		this.references = references;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NonFunctionalReq getNonFunctionalReq() {
		return nonFunctionalReq;
	}

	public void setNonFunctionalReq(NonFunctionalReq nonFunctionalReq) {
		this.nonFunctionalReq = nonFunctionalReq;
	}

	public long getReference_id() {
		return reference_id;
	}

	public void setReference_id(long reference_id) {
		this.reference_id = reference_id;
	}

	public String getTypeOfReq() {
		return typeOfReq;
	}

	public void setTypeOfReq(String typeOfReq) {
		this.typeOfReq = typeOfReq;
	}

	@Override
	public String toString() {
		return "FunctionalReq [id=" + id + ", project=" + project + ", name="
				+ name + ", prerequisites=" + prerequisites + ", references="
				+ references + ", description=" + description
				+ ", nonFunctionalReq=" + nonFunctionalReq + ", reference_id="
				+ reference_id + ", typeOfReq=" + typeOfReq + "]";
	}


}
