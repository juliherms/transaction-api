package com.example.api.transactionapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.api.transactionapi.enums.FlagCard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class represents Credit Card
 * @author j.a.vasconcelos
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TB_CREDIT_CARD")
public class CreditCard extends EntityBase {

	@Column(name = "NUMBER", nullable = false)
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(name = "FLAG", nullable = false)
	private FlagCard flag;

	@Column(name = "TOKEN_NUMBER")
	private String tokenNumber;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

}
