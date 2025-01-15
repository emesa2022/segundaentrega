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

import com.exequiel.models.Categoria;
import com.exequiel.services.CategoriaService;

@RestController
@RequestMapping("/api/Categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/traerCategorias")
	public ResponseEntity<List<Categoria>> getAllCategorias() {
		try {
			List<Categoria> Categorias = categoriaService.getAllCategorias();
			return ResponseEntity.ok(Categorias);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
		try {

			Categoria Categoria = categoriaService.findById(id);
			return ResponseEntity.ok(Categoria);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria Categoria) {
		try {

			Categoria CategoriaCreado = categoriaService.saveCategoria(Categoria);
			return ResponseEntity.ok(CategoriaCreado);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> updateCategoriaById(@PathVariable Long id, @RequestBody Categoria categoriaModificado){
		try {

			Categoria updateCategoria = categoriaService.updateCategoriaById(id, categoriaModificado);
			return ResponseEntity.ok(updateCategoria);
	
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategoriaById(@PathVariable long id){
		try {
			categoriaService.deleteCategoriaById(id);
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	
	
}
