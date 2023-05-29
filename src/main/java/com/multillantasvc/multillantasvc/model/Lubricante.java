package com.multillantasvc.multillantasvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_lubricante")
public class Lubricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_lubricante ;
	@NotEmpty
	@Column(name = "nombre_lubricante")
	private String nombre_lubricante;
	@NotEmpty
	@Column(name = "marca_lubricante")
	private String marca_lubricante ;
	@NotEmpty
	@Column(name = "capacidad_lubricante")
	private String capacidad_lubricante; 
	//
	@JoinColumn(name="categoria_lubricante")
	private int categoria_lubricante ;
	
	@NotNull
	@Min(value = 1)
	@Column(name = "stock_lubricante")
	private int stock_lubricante ;
	
	@NotNull
    @Min(value = 10)
    //@Max(message="El precio máximo es 100", value = 10)
	@Column(name = "preciocosto_lubricante")
	private double preciocosto_lubricante; 
	
	@NotNull
    @Min( value = 10)
	@Column(name = "precioventa_lubricante")
	private double precioventa_lubricante ;
	
	
	public int getId_lubricante() {
		return id_lubricante;
	}
	public void setId_lubricante(int id_lubricante) {
		this.id_lubricante = id_lubricante;
	}
	public String getNombre_lubricante() {
		return nombre_lubricante;
	}
	public void setNombre_lubricante(String nombre_lubricante) {
		this.nombre_lubricante = nombre_lubricante;
	}
	public String getMarca_lubricante() {
		return marca_lubricante;
	}
	public void setMarca_lubricante(String marca_lubricante) {
		this.marca_lubricante = marca_lubricante;
	}
	public String getCapacidad_lubricante() {
		return capacidad_lubricante;
	}
	public void setCapacidad_lubricante(String capacidad_lubricante) {
		this.capacidad_lubricante = capacidad_lubricante;
	}
	public int getCategoria_lubricante() {
		return categoria_lubricante;
	}
	public void setCategoria_lubricante(int categoria_lubricante) {
		this.categoria_lubricante = categoria_lubricante;
	}
	public int getStock_lubricante() {
		return stock_lubricante;
	}
	public void setStock_lubricante(int stock_lubricante) {
		this.stock_lubricante = stock_lubricante;
	}
	public double getPreciocosto_lubricante() {
		return preciocosto_lubricante;
	}
	public void setPreciocosto_lubricante(double preciocosto_lubricante) {
		this.preciocosto_lubricante = preciocosto_lubricante;
	}
	public double getPrecioventa_lubricante() {
		return precioventa_lubricante;
	}
	public void setPrecioventa_lubricante(double precioventa_lubricante) {
		this.precioventa_lubricante = precioventa_lubricante;
	}
	
	@Override
	public String toString() {
		return "Lubricante [id_lubricante=" + id_lubricante + ", nombre_lubricante=" + nombre_lubricante
				+ ", marca_lubricante=" + marca_lubricante + ", capacidad_lubricante=" + capacidad_lubricante
				+ ", categoria_lubricante=" + categoria_lubricante + ", stock_lubricante=" + stock_lubricante
				+ ", preciocosto_lubricante=" + preciocosto_lubricante + ", precioventa_lubricante="
				+ precioventa_lubricante + "]";
	}

	
	
	
	
}
