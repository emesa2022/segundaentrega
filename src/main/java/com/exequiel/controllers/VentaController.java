package com.exequiel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exequiel.models.Venta;
import com.exequiel.repositories.VentaRepository;

@RestController
@RequestMapping("/api/Ventas")
public class VentaController {
	
	@Autowired
	private VentaRepository ventaRepository;
	
	@GetMapping("/traerVentas")
	public List<Venta> getAllVentas(){
		return ventaRepository.findAll();
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> getVentaById(@PathVariable Long id){
		if(ventaRepository.existsById(id)) {
			Venta venta = ventaRepository.findById(id).get();
			return ResponseEntity.ok(venta);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PostMapping
	public Venta createVenta(@RequestBody Venta venta) {
		return ventaRepository.save(venta);
	}
	
	
}
