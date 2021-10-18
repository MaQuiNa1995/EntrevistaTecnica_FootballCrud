package com.github.maquina1995.football.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class TeamDto extends AbstractDto<Long> implements Serializable {

	private String nombre;
	private String ciudad;
	private String propietario;
	private Integer capacidadEstadio;
	private DivisionEnum division;
	private String competicion;
	private Integer numeroJugadores;
	private LocalDate fechaCreacion;
}
