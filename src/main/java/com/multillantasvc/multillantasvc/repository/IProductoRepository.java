package com.multillantasvc.multillantasvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multillantasvc.multillantasvc.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer>{

}
