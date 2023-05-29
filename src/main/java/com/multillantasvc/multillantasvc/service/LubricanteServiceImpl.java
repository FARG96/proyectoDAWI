package com.multillantasvc.multillantasvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multillantasvc.multillantasvc.model.Lubricante;
import com.multillantasvc.multillantasvc.repository.ILubricanteRepository;

@Service
public class LubricanteServiceImpl implements ILubricantesService{

	@SuppressWarnings("unused")
	@Autowired
	private ILubricanteRepository ilubricanterepository;
	@Override
	public List<Lubricante> listartodos() {
		
		return (List<Lubricante>)ilubricanterepository.findAll();
	}

	@Override
	public void guardar(Lubricante lubricante) {
		ilubricanterepository.save(lubricante);
		
	}

	@Override
	public Lubricante BuscarporId(int id) {
		
		return ilubricanterepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		ilubricanterepository.deleteById(id);
		
	}
	

}
