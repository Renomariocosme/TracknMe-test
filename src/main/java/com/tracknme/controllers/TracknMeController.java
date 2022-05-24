package com.tracknme.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tracknme.Model.TracknMeModel;
import com.tracknme.repository.TracknMeRepository;
import com.tracknme.service.TracknMeService;

@RestController
public class TracknMeController {

	@Autowired
	private TracknMeRepository tracknmeRepository;
	
	@Autowired
	private TracknMeService service;
	
	public TracknMeController(TracknMeRepository tracknmeRepository, TracknMeService service) {
		this.tracknmeRepository = tracknmeRepository;
		this.service = service;
	}
	
	
	@GetMapping("/track")
	private List<TracknMeModel> findAll(){
		return StreamSupport.stream(tracknmeRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/track/{id}")
	private TracknMeModel findById(@PathVariable ("id") Long id) {
		return tracknmeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/track/cep/{cep}")
	private List<TracknMeModel> getById(@PathVariable String cep) {
		return tracknmeRepository.findByCep(cep);
	}
	
	@PostMapping("/track")
	public TracknMeModel save(@Valid @RequestBody TracknMeModel tracknmemodel ) {
		return tracknmeRepository.save(tracknmemodel);
	}
	
	@PutMapping("/track/{id}")
	private TracknMeModel update(@Valid @RequestBody TracknMeModel tracknmemodel, @PathVariable("id") Long id) {
		findById(id);
		tracknmemodel.setId(id);
		
		return tracknmeRepository.save(tracknmemodel);
	}
	
	@DeleteMapping("/track/{id}")
	public void delete(@PathVariable("id") Long id) {
		findById(id);
		tracknmeRepository.deleteById(id);
		service.Deleting(id);
	}
	
	
}
