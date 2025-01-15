package com.exequiel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exequiel.models.Cliente;
import com.exequiel.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente  findById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("cliente no encontrado"));
	}
	
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public Cliente updateClienteById(Long id, Cliente clienteDetails) {
		
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El cliente no se encontro"));
		
		cliente.setNombre(clienteDetails.getNombre());
		cliente.setApellido(clienteDetails.getApellido());
		
		return clienteRepository.save(cliente);
	}
	
	public void deleteClienteById(Long id) {
		if(!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("Cliente eliminado");
		}
		clienteRepository.deleteById(id);
	}
	
}
