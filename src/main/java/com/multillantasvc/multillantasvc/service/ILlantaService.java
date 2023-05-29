package com.multillantasvc.multillantasvc.service;

import java.util.List;

import com.multillantasvc.multillantasvc.model.Llanta;

public interface ILlantaService {
	
	void save(Llanta llanta);
	List<Llanta> getAll();
	public Llanta buscarLlantaPorId(int id);
	public void elminarLlanta(int id);

}
