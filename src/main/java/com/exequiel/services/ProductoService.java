package com.exequiel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exequiel.models.Producto;
import com.exequiel.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}
	
	public Producto  findById(Long id) {
		return productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
	}
	
	@Transactional
	public Producto saveProducto(Producto Producto) {
		return productoRepository.save(Producto);
	}
	
	@Transactional
	public Producto updateProductoById(Long id, Producto ProductoDetails) {
		
		Producto Producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El Producto no se encontro"));
		
		Producto.setProducto(ProductoDetails.getProducto());
		Producto.setCantidad(ProductoDetails.getCantidad());
		
		return productoRepository.save(Producto);
	}
	
	public void deleteProductoById(Long id) {
		if(!productoRepository.existsById(id)) {
			throw new IllegalArgumentException("Producto eliminado");
		}
		productoRepository.deleteById(id);
	}
	
}
