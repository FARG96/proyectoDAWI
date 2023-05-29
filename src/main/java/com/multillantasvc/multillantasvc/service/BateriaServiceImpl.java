package com.multillantasvc.multillantasvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multillantasvc.multillantasvc.model.Bateria;
import com.multillantasvc.multillantasvc.repository.IBateriaRepository;

@Service
public class BateriaServiceImpl implements IBateriaService{

	//declaro el repositorio 
	IBateriaRepository ibateriarepository;
	@Override
	public List<Bateria> listartodos() {
		
		return (List<Bateria>) ibateriarepository.findAll();
	}

	@Override
	public void guardar(Bateria bateria) {
		ibateriarepository.save(bateria);
		
	}

	@Override
	public Bateria BuscarporId(int id) {
		// TODO Auto-generated method stub
		return ibateriarepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		ibateriarepository.deleteById(id);;
		
	}

}
