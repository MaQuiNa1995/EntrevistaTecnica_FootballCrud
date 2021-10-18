package com.github.maquina1995.football.entity;

import java.io.Serializable;

/**
 * Se encarga de marcar una clase como candidata a poder ser persistida en base
 * de datos
 * 
 * @param <K> Tipo del objeto que es la clave primaria de una entidad de base de
 *            datos que implementa esta clase
 */
public interface Persistible<K extends Serializable> {

	/**
	 * Obtiene la clave primaria {@link K}
	 * <p>
	 * Por como está hecho el proyecto este se daría cuando te has olvidado de
	 * añadir la vlace primaria llamada <code>id</code> a la entidad no hace falta
	 * hacer la implementación ya que esta se generaría con lombok
	 * 
	 * @return {@link K} clave primaria de la entidad
	 */
	K getId();

	/**
	 * Setea la clave primaria {@link K}
	 * <p>
	 * Por como está hecho el proyecto este se daría cuando te has olvidado de
	 * añadir la clave primaria llamada <code>id</code> a la entidad no hace falta
	 * hacer la implementación ya que esta se generaría con lombok
	 * 
	 * @param id {@link K} clave primaria a setear de la entidad
	 */
	void setId(K id);

}
