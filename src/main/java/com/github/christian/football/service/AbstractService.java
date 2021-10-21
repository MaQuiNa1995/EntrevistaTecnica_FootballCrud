package com.github.christian.football.service;

import java.util.List;
import java.util.Optional;

import com.github.christian.football.dto.AbstractOutputDto;

/**
 * @param <K> Clave primaria
 * @param <D> Dto
 */
public interface AbstractService<K, D extends AbstractOutputDto<?>> {

	/**
	 * Creación de un {@link D}
	 * 
	 * @param dto
	 * 
	 * @return {@link Optional} de {@link K} que representa la clave primaria o
	 *         vacío no se pudo persistir
	 */
	K create(D dto);

	/**
	 * Obtencion de un {@link D} a traves de su clave primaria {@link K}
	 * 
	 * @param id clave primaria {@link K}
	 * 
	 * @return {@link Optional} de {@link D} de la entidad encontrada o vacío si por
	 *         el contrario no existe en base de datos ese id {@link K}
	 */
	Optional<D> find(K id);

	/**
	 * Obtención de todos los {@link D}
	 * 
	 * @return {@link List} de {@link D} en caso de no encontrar nada devuelve una
	 *         instancia vacía de una {@link List}
	 */
	List<D> findAll();

	/**
	 * 
	 * @param dto {@link D} con los datos a modificar y con la clave primaria
	 *            {@link K} de la entidad a atacar
	 * 
	 * @return {@link Boolean} primitivo indicando el éxito de la operación
	 */
	boolean update(D dto);

	/**
	 * @param id clave primaria {@link K}
	 * 
	 * @return {@link Boolean} primitivo indicando el éxito de la operación
	 */
	boolean delete(K id);

}
