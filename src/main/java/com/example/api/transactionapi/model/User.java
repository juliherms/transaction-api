package com.example.api.transactionapi.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Class represents user in application
 * @author j.a.vasconcelos
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TB_USER")
public class User extends EntityBase {

	@Column(name = "LOGIN", nullable = false)
	private String login;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;

	@Column(name = "CPF", nullable = false)
	private String cpf;

	@Column(name = "BIRTHDAY_DATE", nullable = false)
	private LocalDate birthdayDate;

	@Column(name = "CALL_NUMBER", nullable = false)
	private String callNumber;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<CreditCard> creditCards;
	
	@Column(name = "BALANCE", nullable = false)
	private Double balance;
	
	@Column(name = "ACTIVE", nullable = false)
	private Boolean ativo;

}

