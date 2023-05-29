package com.multillantasvc.multillantasvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multillantasvc.multillantasvc.model.Llanta;

@Repository
public interface ILlantaRepository extends JpaRepository<Llanta, Integer>{

}
