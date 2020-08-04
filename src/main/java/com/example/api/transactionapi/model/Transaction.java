package com.example.api.transactionapi.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class responsible to represents transaction in the system
 * @author j.a.vasconcelos
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TB_TRANSACTION")
public class Transaction extends EntityBase {

	@Column(name = "CODE", nullable = false)
	private String code;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "TR_USER_SOURCE", nullable = false)
	private User userSource;

	@ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "TR_USER_DESTINITY", nullable = false)
	private User userDestinity;

	@Column(name = "TR_DATE_TIME", nullable = false)
	private LocalDateTime dateTime;

	@Column(name = "TR_VALUE", nullable = false)
	private Double value;

}
