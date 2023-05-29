package com.multillantasvc.multillantasvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multillantasvc.multillantasvc.model.Filtro;

@Repository
public interface IFiltroRepository extends JpaRepository<Filtro, Integer> {

}
