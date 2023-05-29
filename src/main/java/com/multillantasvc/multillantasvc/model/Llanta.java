package com.multillantasvc.multillantasvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_llanta")
public class Llanta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_llanta")
	private int id_llanta;
	
	@JoinColumn(name = "id_tipovehiculo")
	private int id_tipovehiculo;
	
	@Column(name = "nombre_llanta")
	private String nombre_llanta;
	
	@Column(name = "marca_llanta")
	private String marca_llanta;
	
	@Column(name = "rodaje_llanta")
	private String rodaje_llanta;
	
	@Column(name = "preciocosto_llanta")
	private double preciocosto_llanta;
	
	@Column(name = "precioventa_llanta")
	private double precioventa_llanta;
	
	@Column(name = "precioventa_llanta_credito")
	private double precioventa_llanta_credito;
	
	@Column(name = "stock_llanta")
	private int stock_llanta;

	public int getId_llanta() {
		return id_llanta;
	}

	public void setId_llanta(int id_llanta) {
		this.id_llanta = id_llanta;
	}

	public int getId_tipovehiculo() {
		return id_tipovehiculo;
	}

	public void setId_tipovehiculo(int id_tipovehiculo) {
		this.id_tipovehiculo = id_tipovehiculo;
	}

	public String getNombre_llanta() {
		return nombre_llanta;
	}

	public void setNombre_llanta(String nombre_llanta) {
		this.nombre_llanta = nombre_llanta;
	}

	public String getMarca_llanta() {
		return marca_llanta;
	}

	public void setMarca_llanta(String marca_llanta) {
		this.marca_llanta = marca_llanta;
	}

	public String getRodaje_llanta() {
		return rodaje_llanta;
	}

	public void setRodaje_llanta(String rodaje_llanta) {
		this.rodaje_llanta = rodaje_llanta;
	}

	public double getPreciocosto_llanta() {
		return preciocosto_llanta;
	}

	public void setPreciocosto_llanta(double preciocosto_llanta) {
		this.preciocosto_llanta = preciocosto_llanta;
	}

	public double getPrecioventa_llanta() {
		return precioventa_llanta;
	}

	public void setPrecioventa_llanta(double precioventa_llanta) {
		this.precioventa_llanta = precioventa_llanta;
	}

	public double getPrecioventa_llanta_credito() {
		return precioventa_llanta_credito;
	}

	public void setPrecioventa_llanta_credito(double precioventa_llanta_credito) {
		this.precioventa_llanta_credito = precioventa_llanta_credito;
	}

	public int getStock_llanta() {
		return stock_llanta;
	}

	public void setStock_llanta(int stock_llanta) {
		this.stock_llanta = stock_llanta;
	}

	
	
	

}
