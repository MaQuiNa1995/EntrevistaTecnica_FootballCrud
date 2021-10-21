package com.github.christian.football.mapper;

import com.github.christian.football.dto.AbstractDto;
import com.github.christian.football.entity.Persistible;

/**
 * Encargado de la transformación de tipos delegando la generación del mapper a
 * <code>MapStructs</code>
 *
 * @param <E> Entidad
 * @param <D> Dto
 */
public interface AbstractMapper<E extends Persistible<?>, D extends AbstractDto<?>> {

	/**
	 * Transforma un {@link E} a un {@link D}
	 * 
	 * @param entity {@link E} a ser transformada
	 * 
	 * @return {@link D} resultante
	 */
	D entityToDto(E entity);

	/**
	 * Transforma un {@link D} a un {@link E}
	 * 
	 * @param entity {@link D} a ser transformada
	 * 
	 * @return {@link E} resultante
	 */
	E dtoToEntity(D dto);

}
