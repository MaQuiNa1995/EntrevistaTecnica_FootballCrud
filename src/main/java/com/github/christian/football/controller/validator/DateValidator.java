package com.github.christian.football.controller.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class DateValidator implements ConstraintValidator<CheckDate, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		return value.isBefore(LocalDate.now());
	}
}
