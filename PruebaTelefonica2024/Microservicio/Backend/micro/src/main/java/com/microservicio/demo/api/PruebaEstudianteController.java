package com.microservicio.demo.api;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.demo.dto.PruebaEstudianteDto;
import com.microservicio.demo.model.PruebaEstudianteEntity;
import com.microservicio.demo.service.PruebaEstudianteService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class PruebaEstudianteController {
	
	@Autowired
	PruebaEstudianteService service;
	
	@PostMapping("/create")
	public ResponseEntity<PruebaEstudianteEntity> createPruebaEstudiante(@RequestBody PruebaEstudianteDto dto) {
		PruebaEstudianteEntity entity = service.postPruebaEstudiante(dto);
		return ResponseEntity.ok(entity);
	}

	@GetMapping("/read")
	public List<PruebaEstudianteDto> readPruebaEstudiante() {
		return service.getPruebaEstudiante();
	}
	
	@PutMapping("/update")
	public ResponseEntity<PruebaEstudianteEntity> updatePruebaEstudiante(@RequestBody PruebaEstudianteDto dto) {
		PruebaEstudianteEntity entity = service.putPruebaEstudiante(dto);
		return ResponseEntity.ok(entity);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletePruebaEstudiante(@RequestParam int eid) {
		try {
			service.deletePruebaEstudiante(eid);
			return ResponseEntity.ok("Se elimino el registro con eid "+eid+" correctamente");
		} catch(EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro con eid " + eid);
		}
	}
}
