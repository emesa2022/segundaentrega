package com.exequiel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exequiel.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
