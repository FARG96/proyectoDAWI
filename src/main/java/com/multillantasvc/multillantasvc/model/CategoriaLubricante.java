package com.multillantasvc.multillantasvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_categorialubricante")
public class CategoriaLubricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categorialubricante")
	private int id_categorialubricante;
	@Column(name="nombre_categoria")
	private String nombre_categoria;
	@Override
	public String toString() {
		return "CategoriaLubricante [id_categorialubricante=" + id_categorialubricante + ", nombre_categoria="
				+ nombre_categoria + "]";
	}
	public int getId_categorialubricante() {
		return id_categorialubricante;
	}
	public void setId_categorialubricante(int id_categorialubricante) {
		this.id_categorialubricante = id_categorialubricante;
	}
	public String getNombre_categoria() {
		return nombre_categoria;
	}
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	
	
	
	
	

	
	
	
}
