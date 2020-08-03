package com.example.api.transactionapi.conversor;

import java.util.ArrayList;
import java.util.List;

/**
 * This class responsible to converter Entity to DTO and DTO to Entity
 * @author j.a.vasconcelos
 *
 * @param <E>
 * @param <D>
 */
public abstract class ConversorBase<E, D> {

	public abstract D converterEntityToDto(E entity);

	public abstract E converterDtoToEntity(D dto);

	/**
	 * Receive entity list and converter to DTO list
	 * @param entities
	 * @return
	 */
	public List<D> converterEntitiesToDtos(List<E> entities) {
		List<D> dtos = new ArrayList<>();
		entities.stream().forEach(entidade -> dtos.add(converterEntityToDto(entidade)));
		return dtos;
	}

	/**
	 * Receive DTO list and converter to Entity list
	 * @param dtos
	 * @return
	 */
	public List<E> converterDtosToEntities(List<D> dtos) {
		List<E> entities = new ArrayList<>();
		dtos.stream().forEach(dto -> entities.add(converterDtoToEntity(dto)));
		return entities;
	}
	
}

