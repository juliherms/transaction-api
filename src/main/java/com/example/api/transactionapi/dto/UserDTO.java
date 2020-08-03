package com.example.api.transactionapi.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * This class represents user DTO
 * @JsonInclude it is necessary to only load non-null objects
 * @author j.a.vasconcelos
 *
 */
@Data
@JsonInclude(Include.NON_NULL)
public class UserDTO {

	@NotBlank
	private String login;

	private String password;

	private String email;

	private String fullName;

	private String cpf;

	private LocalDate birthDayDate;

	private String callNumber;

	private Double balance;

}
