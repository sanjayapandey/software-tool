package com.und.softwaretool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="weight_factor")
public class WeightFactor {
	@Column(name="id")
	@Id @GeneratedValue
	private long id;
	
	@Column(name="simple")
	private int simple;
	
	@Column(name="average")
	private int average;
	
	@Column(name="complex")
	private long complex;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSimple() {
		return simple;
	}

	public void setSimple(int simple) {
		this.simple = simple;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public long getComplex() {
		return complex;
	}

	public void setComplex(long complex) {
		this.complex = complex;
	}

	@Override
	public String toString() {
		return "WeightFactor [id=" + id + ", simple=" + simple + ", average=" + average + ", complex=" + complex + "]";
	}
	
}
