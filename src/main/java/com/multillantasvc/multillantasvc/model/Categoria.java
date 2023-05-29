package com.multillantasvc.multillantasvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private int id_categoria;
	
	@Column(name = "nombre_categoria")
	private String nombre_categoria;
	
	@Column(name = "estado_categoria")
	private int estado_categoria;
}
