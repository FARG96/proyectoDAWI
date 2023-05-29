package com.multillantasvc.multillantasvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.multillantasvc.multillantasvc.model.Categoria;
import com.multillantasvc.multillantasvc.repository.ICategoriaRepository;

public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	ICategoriaRepository iCategoriaRepository;
	
	@Override
	public void guardarCategoria(Categoria categoria) {
		iCategoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> obtenerCategorias() {
		return iCategoriaRepository.findAll();
	}

	@Override
	public Categoria buscarCategoriaPorId(int id_categoria) {
		return iCategoriaRepository.findById(id_categoria).orElse(null);
	}

	@Override
	public void eliminarCategoria(int id_categoria) {
		iCategoriaRepository.deleteById(id_categoria);
	}

}
