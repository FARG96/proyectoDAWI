package com.multillantasvc.multillantasvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multillantasvc.multillantasvc.model.TipoVehiculo;
import com.multillantasvc.multillantasvc.repository.ITipoVehiculoRepository;

@Service
public class TipoVehiculoServiceImpl implements ITipoVehiculoService{
	
	@Autowired
	ITipoVehiculoRepository iTipoVehiculoRepository;

	@Override
	public List<TipoVehiculo> getAll() {
		return iTipoVehiculoRepository.findAll();
	}

	@Override
	public void guardarTipoVehiculo(TipoVehiculo tipovehiculo) {
		iTipoVehiculoRepository.save(tipovehiculo);
	}

	@Override
	public TipoVehiculo buscarTipoVehiculoPorId(int id) {
		return iTipoVehiculoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarTipoVehiculo(int id) {
		iTipoVehiculoRepository.deleteById(id);
	}
	

}
