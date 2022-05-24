package com.tracknme;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tracknme.Model.TracknMeModel;
import com.tracknme.controllers.TracknMeController;
import com.tracknme.repository.TracknMeRepository;
import com.tracknme.service.TracknMeService;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTestEndPoint {

	
	@InjectMocks
	private TracknMeController controllerendpoint;
	
	
	@Mock
	private TracknMeRepository repository;
	
	
	@Mock
	private TracknMeService service;
	
	
	private TracknMeModel tracknmemodel = new TracknMeModel();
	
	
	@Before
	public void test() throws Exception{
		TracknMeModel tracknmemodel = new TracknMeModel();
		tracknmemodel.setId(1L);
		tracknmemodel.setNome("Mário");
		tracknmemodel.setIdade(60L);
		tracknmemodel.setCep("54720293");
		tracknmemodel.setSexo("Masculino");
		tracknmemodel.setEndereço("Rua Doze");
		tracknmemodel.setBairro("Parque Capibaribe");
		tracknmemodel.setCidade("São Lourenço da Mata");
		tracknmemodel.setEstado("Pernambuco");
				
		TracknMeModel tracknmeModel = new TracknMeModel();
		tracknmemodel.setId(2L);
		tracknmemodel.setNome("Renomário");
		tracknmemodel.setIdade(50L);
		tracknmemodel.setCep("54720293");
		tracknmemodel.setSexo("Masculino");
		tracknmemodel.setEndereço("Rua Doze");
		tracknmemodel.setBairro("Parque Capibaribe");
		tracknmemodel.setCidade("São Lourenço da Mata");
		tracknmemodel.setEstado("Pernambuco");
		
	}
	
	@Test
	public void testingEndPoint() throws Exception{
		service.created(tracknmemodel);
		verify(service, times(1)).created(tracknmemodel);
	}
	
	@Test
	public void testingEndPointDeleting() {
		controllerendpoint.delete(anyLong());
		verify(service, times(1)).Deleting(anyLong());
	}
	
	@Test
	public void testingEndPointUpdating() {
		controllerendpoint.save(tracknmemodel);
		verify(service, times(1)).toUpdate(1L,tracknmemodel);
	}
}
