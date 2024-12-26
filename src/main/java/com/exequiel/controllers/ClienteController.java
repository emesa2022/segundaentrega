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

import com.exequiel.models.Cliente;
import com.exequiel.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/Clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/traerClientes")
	public List<Cliente> getAllClientes(){
		return clienteRepository.findAll();
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
		if(clienteRepository.existsById(id)) {
			Cliente cliente = clienteRepository.findById(id).get();
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
}
