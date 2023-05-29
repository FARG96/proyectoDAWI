package com.multillantasvc.multillantasvc.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipovehiculo")
public class TipoVehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipovehiculo")
	private int id_tipovehiculo;
	
	@Column(name = "nombre_tipovehiculo")
	private String nombre_tipovehiculo;

	public int getId_tipovehiculo() {
		return id_tipovehiculo;
	}

	public void setId_tipovehiculo(int id_tipovehiculo) {
		this.id_tipovehiculo = id_tipovehiculo;
	}

	public String getNombre_tipovehiculo() {
		return nombre_tipovehiculo;
	}

	public void setNombre_tipovehiculo(String nombre_tipovehiculo) {
		this.nombre_tipovehiculo = nombre_tipovehiculo;
	}



	
}
