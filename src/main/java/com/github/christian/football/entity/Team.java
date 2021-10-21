package com.github.christian.football.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Team implements Serializable, Persistible<Long> {

	@GeneratedValue(generator = "teamSequence",
	        strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "teamSequence",
	        allocationSize = 1)
	@EqualsAndHashCode.Exclude
	@Id
	private Long id;
	private String nombre;
	private String ciudad;
	private String propietario;
	private String competicion;
	private Integer capacidadEstadio;
	private Integer division;
	private Integer numJugadores;
	private LocalDate fechaCreacion;
}
