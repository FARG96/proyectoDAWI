package com.multillantasvc.multillantasvc.service;

import java.util.List;

import com.multillantasvc.multillantasvc.model.CategoriaLubricante;

public interface ICategoriaLubricanteService {

	 List<CategoriaLubricante> listarcategoria();
	 public void guardar (CategoriaLubricante categoriaLubricante);
	
}
