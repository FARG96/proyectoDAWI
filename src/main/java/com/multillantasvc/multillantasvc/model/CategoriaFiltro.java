package com.multillantasvc.multillantasvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_categoriafiltro")
public class CategoriaFiltro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoriafiltro")
    private int id_categoriafiltro;

    @Column(name = "nombre_categoriafiltro")
    private String nombre_categoriafiltro;

	public int getId_categoriafiltro() {
		return id_categoriafiltro;
	}

	public void setId_categoriafiltro(int id_categoriafiltro) {
		this.id_categoriafiltro = id_categoriafiltro;
	}

	public String getNombre_categoriafiltro() {
		return nombre_categoriafiltro;
	}

	public void setNombre_categoriafiltro(String nombre_categoriafiltro) {
		this.nombre_categoriafiltro = nombre_categoriafiltro;
	}
    
    

}
