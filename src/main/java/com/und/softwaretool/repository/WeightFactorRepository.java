package com.und.softwaretool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.und.softwaretool.model.WeightFactor;

@Repository
public interface WeightFactorRepository extends CrudRepository<WeightFactor, Long>{
	public WeightFactor findById(long id);
}