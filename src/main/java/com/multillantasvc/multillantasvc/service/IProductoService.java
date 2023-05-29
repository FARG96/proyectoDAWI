package com.multillantasvc.multillantasvc.service;

import java.util.List;

import com.multillantasvc.multillantasvc.model.Llanta;
import com.multillantasvc.multillantasvc.model.Producto;

public interface IProductoService {
	
	void guardarProducto(Producto producto);
	List<Producto> getAll();
	public Producto buscarProductoPorId(int cod_producto);
	public void eliminarProducto(int cod_producto);
}
