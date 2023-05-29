package com.multillantasvc.multillantasvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multillantasvc.multillantasvc.model.Producto;
import com.multillantasvc.multillantasvc.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	IProductoRepository iProductoRepository;

	@Override
	public void guardarProducto(Producto producto) {
		iProductoRepository.save(producto);
	}

	@Override
	public List<Producto> obtenerProductos() {
		return iProductoRepository.findAll();
	}

	@Override
	public Producto buscarProductoPorId(int cod_producto) {
		return iProductoRepository.findById(cod_producto).orElse(null);
	}

	@Override
	public void eliminarProducto(int cod_producto) {
		iProductoRepository.deleteById(cod_producto);

	}

}
