package com.github.christian.football.dto;

import java.io.Serializable;

import javax.validation.constraints.Null;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractOutputDto<K extends Serializable> implements Serializable {
	@Null
	protected K id;
}
