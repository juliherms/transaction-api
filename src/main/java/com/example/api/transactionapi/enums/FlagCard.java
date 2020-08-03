package com.example.api.transactionapi.enums;

/**
 * This enum represents flag card.
 * @author j.a.vasconcelos
 *
 */
public enum FlagCard {

	VISA("Visa"), MASTERCARD("Master Card"), ELO("Elo");

	private String description;

	FlagCard(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
