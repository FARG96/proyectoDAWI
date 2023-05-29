package com.multillantasvc.multillantasvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multillantasvc.multillantasvc.model.TipoVehiculo;

@Repository
public interface ITipoVehiculoRepository extends JpaRepository<TipoVehiculo, Integer> {
	

}