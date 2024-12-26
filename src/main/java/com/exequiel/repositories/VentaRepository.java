package com.exequiel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exequiel.models.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}
