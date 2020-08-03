package com.example.api.transactionapi.service;

import com.example.api.transactionapi.dto.CreditCardDTO;

/**
 * This class responsible to CreditCard Service.
 * @author j.a.vasconcelos
 *
 */
public interface ICreditCardService {
	
	CreditCardDTO save(CreditCardDTO creditCardDTO);

}
