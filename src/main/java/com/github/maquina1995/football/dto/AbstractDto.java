package com.github.maquina1995.football.dto;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractDto<K extends Serializable> implements Serializable {
	protected K id;
}
