package com.und.softwaretool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rcaf")
public class RCAF {
	@Column(name="id")
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@Column(name="s1")
	private int s1;
	
	@Column(name="s2")
	private int s2;
	
	@Column(name="s3")
	private int s3;
	
	@Column(name="s4")
	private int s4;

	@Column(name="s5")
	private int s5;
	
	@Column(name="s6")
	private int s6;
	
	@Column(name="s7")
	private int s7;
	
	@Column(name="s8")
	private int s8;
	
	@Column(name="s9")
	private int s9;
	
	@Column(name="s10")
	private int s10;
	
	@Column(name="s11")
	private int s11;
	
	@Column(name="s12")
	private int s12;
	
	@Column(name="s13")
	private int s13;
	
	@Column(name="s14")
	private int s14;

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

	public int getS1() {
		return s1;
	}

	public void setS1(int s1) {
		this.s1 = s1;
	}

	public int getS2() {
		return s2;
	}

	public void setS2(int s2) {
		this.s2 = s2;
	}

	public int getS3() {
		return s3;
	}

	public void setS3(int s3) {
		this.s3 = s3;
	}

	public int getS4() {
		return s4;
	}

	public void setS4(int s4) {
		this.s4 = s4;
	}

	public int getS5() {
		return s5;
	}

	public void setS5(int s5) {
		this.s5 = s5;
	}

	public int getS6() {
		return s6;
	}

	public void setS6(int s6) {
		this.s6 = s6;
	}

	public int getS7() {
		return s7;
	}

	public void setS7(int s7) {
		this.s7 = s7;
	}

	public int getS8() {
		return s8;
	}

	public void setS8(int s8) {
		this.s8 = s8;
	}

	public int getS9() {
		return s9;
	}

	public void setS9(int s9) {
		this.s9 = s9;
	}

	public int getS10() {
		return s10;
	}

	public void setS10(int s10) {
		this.s10 = s10;
	}

	public int getS11() {
		return s11;
	}

	public void setS11(int s11) {
		this.s11 = s11;
	}

	public int getS12() {
		return s12;
	}

	public void setS12(int s12) {
		this.s12 = s12;
	}

	public int getS13() {
		return s13;
	}

	public void setS13(int s13) {
		this.s13 = s13;
	}

	public int getS14() {
		return s14;
	}

	public void setS14(int s14) {
		this.s14 = s14;
	}

	@Override
	public String toString() {
		return "RCAF [id=" + id + ", project=" + project + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", s4=" + s4
				+ ", s5=" + s5 + ", s6=" + s6 + ", s7=" + s7 + ", s8=" + s8 + ", s9=" + s9 + ", s10=" + s10 + ", s11="
				+ s11 + ", s12=" + s12 + ", s13=" + s13 + ", s14=" + s14 + "]";
	}
}
