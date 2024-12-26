package com.exequiel.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String producto;
	
	@Column(nullable=false)
	private int cantidad = 0;
	
	private LocalDateTime createdAt;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	
				name ="Categoria_Producto", 
				joinColumns = @JoinColumn(name ="categoria_id"),
				inverseJoinColumns = @JoinColumn(name = "producto_id")
				)
	private List<Categoria> Categorias = new ArrayList<>();
	
	
	public Producto() {
		super();
	}
	
	public Producto(String producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}


	public String getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", createdAt=" + createdAt + "]";
	}
	
	
	
}