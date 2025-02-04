package com.microservicio.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "PRUEBAESTUDIANTE")
public class PruebaEstudianteEntity {

	@Id
	@Column(name = "Eid", nullable = false)
    private Integer eid;

	@Column(name = "Nombre", nullable = false)
    private String nombre;
	@Column(name = "Especialidad", nullable = false)
    private String especialidad;
	@Column(name = "Grado", nullable = false)
    private String grado;
}
