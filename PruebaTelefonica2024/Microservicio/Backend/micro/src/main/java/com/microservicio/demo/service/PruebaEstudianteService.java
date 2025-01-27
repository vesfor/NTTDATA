package com.microservicio.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicio.demo.dto.PruebaEstudianteDto;
import com.microservicio.demo.model.PruebaEstudianteEntity;
import com.microservicio.demo.repository.PruebaEstudianteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PruebaEstudianteService {
	
	@Autowired
    private PruebaEstudianteRepository repository;
	
	public PruebaEstudianteEntity postPruebaEstudiante(PruebaEstudianteDto dto) {
		PruebaEstudianteEntity entity = new PruebaEstudianteEntity();
		entity.setEid(dto.getEid());
		entity.setEspecialidad(dto.getEspecialidad());
		entity.setGrado(dto.getGrado());
		entity.setNombre(dto.getNombre());
		return repository.save(entity);
	}
	
	@Transactional
	public List<PruebaEstudianteDto> getPruebaEstudiante() {
		List<PruebaEstudianteEntity> pruebaEntity = repository.findAll();
		return pruebaEntity.stream()
				.map(prueba-> { PruebaEstudianteDto dto = new PruebaEstudianteDto();
								dto.setEid(prueba.getEid());
				                dto.setNombre(prueba.getNombre());
				                dto.setEspecialidad(prueba.getEspecialidad());
				                dto.setGrado(prueba.getGrado());
				                return dto;
				}).collect(Collectors.toList());
	}
	
	public PruebaEstudianteEntity putPruebaEstudiante(PruebaEstudianteDto dto) {
		Optional<PruebaEstudianteEntity> option = repository.findById(dto.getEid());
		
		if(option.isPresent()) {
			PruebaEstudianteEntity entity = option.get();
			
			entity.setEspecialidad(dto.getEspecialidad());
			entity.setGrado(dto.getGrado());
			entity.setNombre(dto.getNombre());
			return repository.save(entity);
		} else {
			throw new EntityNotFoundException("El registro "+dto.getEid()+" no existe en la BD.");
		}
		
	}
	
	public void deletePruebaEstudiante(int eid) {
		if(!repository.existsById(eid)) {
			throw new EntityNotFoundException("No se encontró el registro con eid " + eid);
		}
		repository.deleteById(eid);
	}

}
