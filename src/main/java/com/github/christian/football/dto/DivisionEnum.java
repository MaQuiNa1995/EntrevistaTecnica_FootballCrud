package com.github.christian.football.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DivisionEnum {
	PRIMERA(1), SEGUNDA(2), TERCERA(3);

	public int division;
}
