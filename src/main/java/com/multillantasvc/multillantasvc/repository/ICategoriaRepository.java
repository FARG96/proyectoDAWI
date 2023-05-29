package com.multillantasvc.multillantasvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multillantasvc.multillantasvc.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
