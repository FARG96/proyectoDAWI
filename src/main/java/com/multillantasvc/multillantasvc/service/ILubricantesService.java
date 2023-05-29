package com.multillantasvc.multillantasvc.service;

import java.util.List;

import com.multillantasvc.multillantasvc.model.Lubricante;

public interface ILubricantesService {

	public List<Lubricante> listartodos();
	public void guardar (Lubricante lubricante);
	public Lubricante BuscarporId(int id);
	public void eliminar(int id);
}
