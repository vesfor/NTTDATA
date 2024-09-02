package com.microservicio.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PruebaEstudianteDto {

	private Integer eid;
	private String nombre;
	private String especialidad;
	private String grado;
}
