package com.github.christian.football.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.christian.football.dto.TeamDto;
import com.github.christian.football.entity.Team;

@Service
public class TeamService extends AbstractServiceImpl<Long, Team, TeamDto> {

	@Override
	protected void updateEntityFields(Team dbEntity, Team newEntity) {

		Integer capacidadEstadio = newEntity.getCapacidadEstadio();
		if (capacidadEstadio != null) {
			dbEntity.setCapacidadEstadio(capacidadEstadio);
		}

		Integer division = newEntity.getDivision();
		if (division != null) {
			dbEntity.setDivision(division);
		}

		Integer numJugadores = newEntity.getNumJugadores();
		if (numJugadores != null) {
			dbEntity.setNumJugadores(numJugadores);
		}

		LocalDate fechaCreacion = newEntity.getFechaCreacion();
		if (fechaCreacion != null) {
			dbEntity.setFechaCreacion(fechaCreacion);
		}

		String nombre = newEntity.getNombre();
		if (StringUtils.hasText(nombre)) {
			dbEntity.setNombre(nombre);
		}

		String ciudad = newEntity.getCiudad();
		if (StringUtils.hasText(ciudad)) {
			dbEntity.setCiudad(ciudad);
		}

		String competicion = newEntity.getCompeticion();
		if (StringUtils.hasText(competicion)) {
			dbEntity.setCompeticion(competicion);
		}

		String propietario = newEntity.getPropietario();
		if (StringUtils.hasText(propietario)) {
			dbEntity.setPropietario(propietario);
		}
	}
}
