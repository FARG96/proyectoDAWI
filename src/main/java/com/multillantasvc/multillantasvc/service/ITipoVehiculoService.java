package com.multillantasvc.multillantasvc.service;

import java.util.List;

import com.multillantasvc.multillantasvc.model.TipoVehiculo;

public interface ITipoVehiculoService {

	public void guardarTipoVehiculo(TipoVehiculo tipovehiculo); // CREATE
	List<TipoVehiculo> getAll(); // READ
	public TipoVehiculo buscarTipoVehiculoPorId(int id); // UPDATE - SEARCH
	public void eliminarTipoVehiculo(int id); // DELETE
}
