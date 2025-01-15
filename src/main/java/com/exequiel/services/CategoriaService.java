package com.exequiel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exequiel.models.Categoria;
import com.exequiel.repositories.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}
	
	public Categoria  findById(Long id) {
		return categoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria no encontrado"));
	}
	
	@Transactional
	public Categoria saveCategoria(Categoria Categoria) {
		return categoriaRepository.save(Categoria);
	}
	
	@Transactional
	public Categoria updateCategoriaById(Long id, Categoria CategoriaDetails) {
		
		Categoria Categoria = categoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El Categoria no se encontro"));
		
		Categoria.setNombre(CategoriaDetails.getNombre());
		
		return categoriaRepository.save(Categoria);
	}
	
	public void deleteCategoriaById(Long id) {
		if(!categoriaRepository.existsById(id)) {
			throw new IllegalArgumentException("Categoria eliminado");
		}
		categoriaRepository.deleteById(id);
	}
	
}
