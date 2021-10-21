package com.github.christian.football.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.christian.football.dto.AbstractDto;
import com.github.christian.football.service.AbstractService;

/**
 * Clase abstracta para la creación de webservices de nivel 2
 * 
 * @author MaQuiNa1995
 *
 * @param <S> service
 * @param <E> entity
 * @param <K> clave primaria de la entity
 * @param <D> dto
 */
@Validated
public abstract class AbstractWebserviceController<K extends Serializable, D extends AbstractDto<K>> {

	@Autowired
	protected AbstractService<K, D> service;

	@PostMapping
	public ResponseEntity<K> create(@Valid @RequestBody D dto) {

		return ResponseEntity.ok(service.create(dto));
	}

	@GetMapping
	public ResponseEntity<List<D>> findAll() {

		List<D> dtos = service.findAll();

		return dtos.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT)
		        .build()
		        : ResponseEntity.status(HttpStatus.OK)
		                .body(dtos);

	}

	@GetMapping("/{id}")
	public ResponseEntity<List<D>> find(@RequestParam(required = true) K id) {

		Optional<D> dto = service.find(id);

		return dto.isPresent() ? ResponseEntity.status(HttpStatus.OK)
		        .build()
		        : ResponseEntity.notFound()
		                .build();

	}

	@PatchMapping
	public ResponseEntity<D> update(@Valid @RequestBody D dto) {

		boolean updated = service.update(dto);

		return updated ? ResponseEntity.status(HttpStatus.NO_CONTENT)
		        .build()
		        : ResponseEntity.notFound()
		                .build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<D> delete(@RequestParam(required = true) K id) {
		service.delete(id);
		return ResponseEntity.noContent()
		        .build();
	}

}
