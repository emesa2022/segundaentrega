package com.exequiel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exequiel.models.Producto;
import com.exequiel.services.ProductoService;

@RestController
@RequestMapping("/api/Productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;

	@GetMapping("/traerProductos")
	public ResponseEntity<List<Producto>> getAllProductos() {
		try {
			List<Producto> Productos = productoService.getAllProductos();
			return ResponseEntity.ok(Productos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
		try {

			Producto Producto = productoService.findById(id);
			return ResponseEntity.ok(Producto);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<Producto> createProducto(@RequestBody Producto Producto) {
		try {

			Producto ProductoCreado = productoService.saveProducto(Producto);
			return ResponseEntity.ok(ProductoCreado);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> updateProductoById(@PathVariable Long id, @RequestBody Producto ProductoModificado){
		try {

			Producto updateProducto = productoService.updateProductoById(id, ProductoModificado);
			return ResponseEntity.ok(updateProducto);
	
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductoById(@PathVariable long id){
		try {
			productoService.deleteProductoById(id);
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	
	
}
