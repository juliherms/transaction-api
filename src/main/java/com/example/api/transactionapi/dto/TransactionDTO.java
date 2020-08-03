package com.example.api.transactionapi.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * This class represents DTO for Transaction.
 * @JsonInclude it is necessary to only load non-null objects
 * @author j.a.vasconcelos
 *
 */
@Data
@JsonInclude(Include.NON_NULL)
public class TransactionDTO {

	@NotBlank
	private String code;

	@NotNull
	private UserDTO source;

	@NotNull
	private UserDTO destiny;

	@NotNull
	private LocalDateTime dateAndHour;

	@NotNull
	private Double value;

	private CreditCardDTO creditCardDTO;

	private Boolean isCreditCard = false;

}
