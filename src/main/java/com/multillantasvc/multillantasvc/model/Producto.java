package com.multillantasvc.multillantasvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_producto")
	private int cod_producto;

	@Column(name = "nombre_producto")
	private String nombre_producto;

	@Column(name = "descripcion_producto")
	private String descripcion_producto;

	@Column(name = "marca_producto")
	private String marca_producto;

	@Column(name = "stock_producto")
	private int stock_producto;

	@Column(name = "precio_costo")
	private double precio_costo;

	@Column(name = "precio_venta")
	private double precio_venta;

	@Column(name = "precio_credito")
	private double precio_credito;

	@Column(name = "estado_producto")
	private int estado_producto;

	@Column(name = "id_categoria")
	private int id_categoria;

	public int getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public String getMarca_producto() {
		return marca_producto;
	}

	public void setMarca_producto(String marca_producto) {
		this.marca_producto = marca_producto;
	}

	public int getStock_producto() {
		return stock_producto;
	}

	public void setStock_producto(int stock_producto) {
		this.stock_producto = stock_producto;
	}

	public double getPrecio_costo() {
		return precio_costo;
	}

	public void setPrecio_costo(double precio_costo) {
		this.precio_costo = precio_costo;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public double getPrecio_credito() {
		return precio_credito;
	}

	public void setPrecio_credito(double precio_credito) {
		this.precio_credito = precio_credito;
	}

	public int getEstado_producto() {
		return estado_producto;
	}

	public void setEstado_producto(int estado_producto) {
		this.estado_producto = estado_producto;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

}
