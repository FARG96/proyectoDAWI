package com.multillantasvc.multillantasvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multillantasvc.multillantasvc.model.Llanta;
import com.multillantasvc.multillantasvc.repository.ILlantaRepository;

@Service
public class LlantaServiceImpl implements ILlantaService{

	@Autowired
	ILlantaRepository iLlantaRepository;
	
	@Override
	public void save(Llanta llanta) {
		iLlantaRepository.save(llanta);
		
	}

	@Override
	public List<Llanta> getAll() {
		return iLlantaRepository.findAll();
	}

	@Override
	public Llanta buscarLlantaPorId(int id) {
		return iLlantaRepository.findById(id).orElse(null);
	}

	@Override
	public void elminarLlanta(int id) {
		iLlantaRepository.deleteById(id);
	}

}
