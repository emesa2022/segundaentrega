package com.exequiel.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String producto;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private LocalDateTime createdAt;
	private int nVenta = 0;
	
	
	
	
	
	
	public Venta() {
		super();
	}
	
	public Venta(String producto) {
		super();
		this.producto = producto;
	}


	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getnVenta() {
		return nVenta;
	}

	public void setnVenta(int nVenta) {
		this.nVenta = nVenta;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", nVenta=" + nVenta + ", createdAt=" + createdAt + "]";
	}
	
	
	
}