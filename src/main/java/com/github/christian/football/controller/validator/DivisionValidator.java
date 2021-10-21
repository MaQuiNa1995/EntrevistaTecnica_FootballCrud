package com.github.christian.football.controller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.christian.football.dto.TeamDto;

class DivisionValidator implements ConstraintValidator<CheckDivisionAndCapacity, TeamDto> {

	@Override
	public boolean isValid(TeamDto value, ConstraintValidatorContext context) {

		boolean condition = false;

		switch (value.getDivision()) {
		case 1:
			condition = value.getCapacidadEstadio() > 50000;
			break;
		case 2:
			condition = value.getCapacidadEstadio() > 10000;
			break;
		case 3:
			condition = value.getCapacidadEstadio() > 3000;
			break;
		}

		if (!condition) {
			String validationMessage = this.buildValidationMessage(value.getDivision(), value.getCapacidadEstadio());
			context.buildConstraintViolationWithTemplate(validationMessage);
		}

		return condition;
	}

	private String buildValidationMessage(Integer division, Integer capacidad) {
		return String.format("Para la división %d proporcionada la capacidad del estadio debe ser mayor de %d",
		        division, capacidad);
	}
}
