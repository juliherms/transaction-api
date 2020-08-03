package com.example.api.transactionapi.dto;

import javax.validation.constraints.NotBlank;

import com.example.api.transactionapi.enums.FlagCard;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sun.istack.NotNull;

import lombok.Data;

/**
 * This class represents Credit Card
 * @JsonInclude it is necessary to only load non-null objects
 * @author j.a.vasconcelos
 *
 */
@Data
@JsonInclude(Include.NON_NULL)
public class CreditCardDTO {

	@NotBlank
	private FlagCard bandeira;

	@NotBlank
	private String securityCode;

	@NotBlank
	private String expirationDate;

	@NotBlank
	private String titularName;

	private String number;

	private String tokenNumber;

	@NotNull
	private UserDTO user;

	private Boolean isSave = false;

}