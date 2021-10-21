package com.github.christian.football.controller.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DivisionValidator.class)
@Documented
public @interface CheckDivisionAndCapacity {

	String message() default "La capacidad del estadio es incorrecta, para la división PRIMERA -> 50.000 para la SEGUNDA -> 10.000 y para la TERCERA -> 3000";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
