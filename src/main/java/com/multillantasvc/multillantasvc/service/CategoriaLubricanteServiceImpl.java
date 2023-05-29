package com.multillantasvc.multillantasvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multillantasvc.multillantasvc.model.CategoriaLubricante;
import com.multillantasvc.multillantasvc.repository.ICategoriaLubricanteRepository;

@Service
public class CategoriaLubricanteServiceImpl implements ICategoriaLubricanteService{

	@Autowired 
	private ICategoriaLubricanteRepository categorialubricanterepository;
	@Override
	public List<CategoriaLubricante> listarcategoria() {
		
		return (List<CategoriaLubricante>)categorialubricanterepository.findAll();
	}
	@Override
	public void guardar(CategoriaLubricante categoriaLubricante) {
		categorialubricanterepository.save(categoriaLubricante);
		
	}
	
	

}
