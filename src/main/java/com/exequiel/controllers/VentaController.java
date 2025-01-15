package com.exequiel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exequiel.models.Venta;
import com.exequiel.services.VentaService;

@RestController
@RequestMapping("/api/Ventas")
public class VentaController {
	
	@Autowired
	private VentaService ventaService;
	
	@GetMapping("/traerVentas")
	public ResponseEntity<List<Venta>> getAllVentas(){
		try {
			List<Venta> ventas = ventaService.getAllVentas();
			return ResponseEntity.ok(ventas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> getVentaById(@PathVariable Long id){
		try {

			Venta venta = ventaService.findById(id);
			return ResponseEntity.ok(venta);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
		try {

			Venta ventaCreada = ventaService.saveVenta(venta);
			return ResponseEntity.ok(ventaCreada);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVentaById(@PathVariable long id){
		try {
			ventaService.deleteVentaById(id);
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
