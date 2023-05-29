package com.multillantasvc.multillantasvc.service;

import java.util.List;

import com.multillantasvc.multillantasvc.model.Categoria;


public interface ICategoriaService {
	
	void guardarCategoria(Categoria categoria);
	List<Categoria> obtenerCategorias();
	public Categoria buscarCategoriaPorId(int id_categoria);
	public void eliminarCategoria(int id_categoria);

}
