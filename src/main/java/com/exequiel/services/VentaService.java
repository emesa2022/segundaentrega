package com.exequiel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exequiel.models.Venta;
import com.exequiel.repositories.VentaRepository;

import jakarta.transaction.Transactional;

@Service
public class VentaService {

	@Autowired
	private VentaRepository ventaRepository;
	
	public List<Venta> getAllVentas() {
		return ventaRepository.findAll();
	}
	
	public Venta findById(Long id) {
		return ventaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("venta no encontrado"));
	}
	
	@Transactional
	public Venta saveVenta(Venta venta) {
		return ventaRepository.save(venta);
	}
	
	public void deleteVentaById(Long id) {
		if(!ventaRepository.existsById(id)) {
			throw new IllegalArgumentException("Venta eliminado");
		}
		ventaRepository.deleteById(id);
	}
	
}
