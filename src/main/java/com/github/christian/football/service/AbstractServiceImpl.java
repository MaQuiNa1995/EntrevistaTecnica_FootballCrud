package com.github.christian.football.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.christian.football.dto.AbstractDto;
import com.github.christian.football.entity.Persistible;
import com.github.christian.football.mapper.AbstractMapper;

/**
 * 
 * @param <K> Clave primaria de la entidad y del Dto
 * @param <E> Entidad
 * @param <D> Dto
 */
public abstract class AbstractServiceImpl<K extends Serializable, E extends Persistible<K>, D extends AbstractDto<K>>
        implements AbstractService<K, D> {

	@Autowired
	protected JpaRepository<E, K> repository;
	@Autowired
	protected AbstractMapper<E, D> mapper;

	protected abstract void updateEntityFields(E dbEntity, E newEntity);

	@Override
	public K create(D dto) {

		E entity = mapper.dtoToEntity(dto);
		return repository.save(entity)
		        .getId();
	}

	@Override
	public Optional<D> find(K id) {

		E entity = repository.findById(id)
		        .orElse(null);
		return Optional.ofNullable(mapper.entityToDto(entity));
	}

	@Override
	public List<D> findAll() {

		return repository.findAll()
		        .stream()
		        .map(mapper::entityToDto)
		        .collect(Collectors.toList());
	}

	@Override
	public boolean update(D dto) {

		boolean updated = false;

		E entity = mapper.dtoToEntity(dto);
		Optional<E> entityToUpdate = repository.findById(dto.getId());

		if (entityToUpdate.isPresent()) {

			E dbEntity = entityToUpdate.get();

			updateEntityFields(dbEntity, entity);
			entity.setId(dbEntity.getId());

			updated = true;
		}

		return updated;
	}

	@Override
	public boolean delete(K id) {

		boolean success = false;

		Optional<E> entity = repository.findById(id);

		if (entity.isPresent()) {
			repository.deleteById(entity.get()
			        .getId());
			success = true;
		}

		return success;

	}

}