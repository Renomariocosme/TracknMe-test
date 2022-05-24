package com.tracknme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tracknme.Model.TracknMeModel;
import com.tracknme.repository.TracknMeRepository;

@Service
public class TracknMeService {

	@Autowired(required=false)
	private TracknMeModel tracknmemodel;
	
	
	@Autowired
	private TracknMeRepository repository;

	
	public TracknMeModel created(TracknMeModel servidor) throws Exception{
		TracknMeModel tracknmmodel = new TracknMeModel();
		

		if(servidor.getNome()== null || servidor.getNome().isBlank()) {
			throw new Error("O nome precisa ser preenchido!");
		} else {
			tracknmmodel.setNome(servidor.getNome());
		}
		if(servidor.getIdade() == null) {
			throw new Exception ("A idade precisa ser preenchida");
		} else {
			tracknmmodel.setIdade(tracknmmodel.getIdade());
		}
		if(tracknmmodel.getCep() == null || tracknmmodel.getCep().isBlank()) {
			throw new Exception ("O CEP precisar ser inserido");
		} else {
			tracknmmodel.setCep(tracknmmodel.getCep());
		}
		
		servidor.setSexo(servidor.getSexo());
		return repository.save(servidor);
	}
	
	public TracknMeModel toUpdate(Long id, TracknMeModel servidor ) {
		TracknMeModel tracknmemodel = repository.getById(id);
		
		if(servidor.getNome() != null) {
			tracknmemodel.setNome(servidor.getNome());
		}
		if(servidor.getIdade() != null) {
			tracknmemodel.setIdade(servidor.getIdade());
		}
		if(servidor.getSexo() != null) {
			tracknmemodel.setSexo(servidor.getSexo());
		}
		return repository.save(tracknmemodel);
	}
	
	public void Deleting(Long id) {
		repository.deleteById(id);
	}
		
}
