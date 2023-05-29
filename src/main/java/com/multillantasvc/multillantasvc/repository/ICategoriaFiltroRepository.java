package com.multillantasvc.multillantasvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multillantasvc.multillantasvc.model.CategoriaFiltro;

@Repository
public interface ICategoriaFiltroRepository extends JpaRepository<CategoriaFiltro, Integer> {

}
