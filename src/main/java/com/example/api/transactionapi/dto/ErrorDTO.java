package com.example.api.transactionapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents Error DTO
 * @JsonInclude it is necessary to only load non-null objects
 * @author j.a.vasconcelos
 *
 */
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ErrorDTO {

	private String field;
	private String message;

}
