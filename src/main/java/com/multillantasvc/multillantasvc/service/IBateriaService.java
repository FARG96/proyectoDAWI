package com.multillantasvc.multillantasvc.service;

import java.util.List;

import com.multillantasvc.multillantasvc.model.Bateria;

public interface IBateriaService {

	public List<Bateria> listartodos();
	public void guardar (Bateria bateria);
	public Bateria BuscarporId(int id);
	public void eliminar(int id);
}
