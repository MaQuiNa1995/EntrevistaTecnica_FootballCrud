package com.github.christian.football.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.github.christian.football.controller.validator.CheckDate;
import com.github.christian.football.controller.validator.CheckDivisionAndCapacity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@CheckDivisionAndCapacity
@EqualsAndHashCode(callSuper = true)
public class TeamDto extends AbstractOutputDto<Long> implements Serializable {

	@NotBlank
	private String nombre;
	private String ciudad;
	private String propietario;
	@Min(3001)
	private Integer capacidadEstadio;
	@Min(1)
	@Max(3)
	private Integer division;
	private String competicion;
	@Min(1)
	private Integer numeroJugadores;
	@CheckDate
	private LocalDate fechaCreacion;
}
