package com.exequiel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exequiel.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long > {

}
