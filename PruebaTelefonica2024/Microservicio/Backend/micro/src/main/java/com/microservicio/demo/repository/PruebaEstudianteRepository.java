package com.microservicio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.demo.model.PruebaEstudianteEntity;

@Repository
public interface PruebaEstudianteRepository extends JpaRepository<PruebaEstudianteEntity, Integer>{

}
