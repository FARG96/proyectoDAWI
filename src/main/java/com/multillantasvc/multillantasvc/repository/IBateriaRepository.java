package com.multillantasvc.multillantasvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multillantasvc.multillantasvc.model.Bateria;

@Repository
public interface IBateriaRepository extends JpaRepository<Bateria, Integer>{
	

}
