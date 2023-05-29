package com.multillantasvc.multillantasvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_bateria")
public class Bateria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id_bateria;
	
	@JoinColumn(name="")
	public int id_tipo_vehiculo;
	
	@Column(name="marca_bateria")
	public String marca_bateria;
	
	@Column(name="modelo_bateria")
	public String modelo_bateria;
	
	@Column(name="numero_placas")
	public int numero_placas;
	
	@Column(name="stock_bateria")
	public int stock_bateria;
	
	@Column(name="preciocosto_bateria")
	public double preciocosto_bateria;
	
	@Column(name="precioventa_bateria")
	public double precioventa_bateria;
	
	@Column(name="precioventa_bateria_credito")
	public double precioventa_bateria_credito;

	public int getId_bateria() {
		return id_bateria;
	}

	public void setId_bateria(int id_bateria) {
		this.id_bateria = id_bateria;
	}

	public int getId_tipo_vehiculo() {
		return id_tipo_vehiculo;
	}

	public void setId_tipo_vehiculo(int id_tipo_vehiculo) {
		this.id_tipo_vehiculo = id_tipo_vehiculo;
	}

	public String getMarca_bateria() {
		return marca_bateria;
	}

	public void setMarca_bateria(String marca_bateria) {
		this.marca_bateria = marca_bateria;
	}

	public String getModelo_bateria() {
		return modelo_bateria;
	}

	public void setModelo_bateria(String modelo_bateria) {
		this.modelo_bateria = modelo_bateria;
	}

	public int getNumero_placas() {
		return numero_placas;
	}

	public void setNumero_placas(int numero_placas) {
		this.numero_placas = numero_placas;
	}

	public int getStock_bateria() {
		return stock_bateria;
	}

	public void setStock_bateria(int stock_bateria) {
		this.stock_bateria = stock_bateria;
	}

	public double getPreciocosto_bateria() {
		return preciocosto_bateria;
	}

	public void setPreciocosto_bateria(double preciocosto_bateria) {
		this.preciocosto_bateria = preciocosto_bateria;
	}

	public double getPrecioventa_bateria() {
		return precioventa_bateria;
	}

	public void setPrecioventa_bateria(double precioventa_bateria) {
		this.precioventa_bateria = precioventa_bateria;
	}

	public double getPrecioventa_bateria_credito() {
		return precioventa_bateria_credito;
	}

	public void setPrecioventa_bateria_credito(double precioventa_bateria_credito) {
		this.precioventa_bateria_credito = precioventa_bateria_credito;
	}

	@Override
	public String toString() {
		return "Bateria [id_bateria=" + id_bateria + ", id_tipo_vehiculo=" + id_tipo_vehiculo + ", marca_bateria="
				+ marca_bateria + ", modelo_bateria=" + modelo_bateria + ", numero_placas=" + numero_placas
				+ ", stock_bateria=" + stock_bateria + ", preciocosto_bateria=" + preciocosto_bateria
				+ ", precioventa_bateria=" + precioventa_bateria + ", precioventa_bateria_credito="
				+ precioventa_bateria_credito + ", getId_bateria()=" + getId_bateria() + ", getId_tipo_vehiculo()="
				+ getId_tipo_vehiculo() + ", getMarca_bateria()=" + getMarca_bateria() + ", getModelo_bateria()="
				+ getModelo_bateria() + ", getNumero_placas()=" + getNumero_placas() + ", getStock_bateria()="
				+ getStock_bateria() + ", getPreciocosto_bateria()=" + getPreciocosto_bateria()
				+ ", getPrecioventa_bateria()=" + getPrecioventa_bateria() + ", getPrecioventa_bateria_credito()="
				+ getPrecioventa_bateria_credito() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
}
