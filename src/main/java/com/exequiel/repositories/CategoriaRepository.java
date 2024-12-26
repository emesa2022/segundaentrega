package com.exequiel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exequiel.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
