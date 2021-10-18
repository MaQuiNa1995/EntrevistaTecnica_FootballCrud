package com.github.maquina1995.football.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.maquina1995.football.dto.AbstractDto;
import com.github.maquina1995.football.entity.Persistible;
import com.github.maquina1995.football.mapper.AbstractMapper;

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
	public Optional<K> create(D dto) {

		E entity = mapper.dtoToEntity(dto);
		return Optional.of(repository.save(entity)
		        .getId());
	}

	@Override
	public Optional<D> find(K id) {

		E entity = repository.findById(id)
		        .orElse(null);
		return Optional.of(mapper.entityToDto(entity));
	}

	@Override
	public List<D> findAll() {

		return repository.findAll()
		        .stream()
		        .map(mapper::entityToDto)
		        .collect(Collectors.toList());
	}

	@Override
	public Optional<D> update(D dto) {

		D updatedDto = null;

		E entity = mapper.dtoToEntity(dto);
		Optional<E> entityToUpdate = repository.findById(dto.getId());

		if (entityToUpdate.isPresent()) {

			E dbEntity = entityToUpdate.get();

			updateEntityFields(dbEntity, entity);
			entity.setId(dbEntity.getId());

			updatedDto = mapper.entityToDto(repository.save(entity));
		}

		return Optional.of(updatedDto);
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