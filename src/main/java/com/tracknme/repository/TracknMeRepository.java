package com.tracknme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tracknme.Model.TracknMeModel;

public interface TracknMeRepository extends CrudRepository<TracknMeModel, Long>{

	List<TracknMeModel> findByCep(String cep);

	TracknMeModel getById(Long id);
}
