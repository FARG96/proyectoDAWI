package com.multillantasvc.multillantasvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_filtro")
public class Filtro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_filtro")
	private int id_filtro;

	@JoinColumn(name = "id_categoriafiltro")
	private int id_categoriafiltro;

	@JoinColumn(name = "id_tipovehiculo")
	private int id_tipovehiculo;

	@Column(name = "nombre_filtro")
	private String nombre_filtro;

	@Column(name = "marca_filtro")
	private String marca_filtro;

	@Column(name = "stock_filtro")
	private int stock_filtro;

	@Column(name = "preciocosto_filtro")
	private double preciocosto_filtro;

	@Column(name = "precioventa_filtro")
	private double precioventa_filtro;

	public int getId_filtro() {
		return id_filtro;
	}

	public void setId_filtro(int id_filtro) {
		this.id_filtro = id_filtro;
	}

	public int getId_categoriafiltro() {
		return id_categoriafiltro;
	}

	public void setId_categoriafiltro(int id_categoriafiltro) {
		this.id_categoriafiltro = id_categoriafiltro;
	}

	public int getId_tipovehiculo() {
		return id_tipovehiculo;
	}

	public void setId_tipovehiculo(int id_tipovehiculo) {
		this.id_tipovehiculo = id_tipovehiculo;
	}

	public String getNombre_filtro() {
		return nombre_filtro;
	}

	public void setNombre_filtro(String nombre_filtro) {
		this.nombre_filtro = nombre_filtro;
	}

	public String getMarca_filtro() {
		return marca_filtro;
	}

	public void setMarca_filtro(String marca_filtro) {
		this.marca_filtro = marca_filtro;
	}

	public int getStock_filtro() {
		return stock_filtro;
	}

	public void setStock_filtro(int stock_filtro) {
		this.stock_filtro = stock_filtro;
	}

	public double getPreciocosto_filtro() {
		return preciocosto_filtro;
	}

	public void setPreciocosto_filtro(double preciocosto_filtro) {
		this.preciocosto_filtro = preciocosto_filtro;
	}

	public double getPrecioventa_filtro() {
		return precioventa_filtro;
	}

	public void setPrecioventa_filtro(double precioventa_filtro) {
		this.precioventa_filtro = precioventa_filtro;
	}

	
}
