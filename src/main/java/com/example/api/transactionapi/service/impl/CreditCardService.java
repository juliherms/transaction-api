package com.example.api.transactionapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.transactionapi.conversor.CreditCardConversor;
import com.example.api.transactionapi.dto.CreditCardDTO;
import com.example.api.transactionapi.model.CreditCard;
import com.example.api.transactionapi.repository.CreditCardRepository;
import com.example.api.transactionapi.service.ICreditCardService;
import com.example.api.transactionapi.service.IUserService;

/**
 * This class responsible to provide service to creditCard
 * @author j.a.vasconcelos
 *
 */
@Service
public class CreditCardService implements ICreditCardService {
	
	@Autowired
	private CreditCardRepository creditCardRepository;

	@Autowired
	private CreditCardConversor cartaoCreditoConversor;
	
	@Autowired
	private IUserService userService;


	@Override
	public CreditCardDTO save(CreditCardDTO creditCardDTO) {
		
		CreditCardDTO creditCardReturn = null;
		
		if (creditCardDTO.getIsSave()) {
			
			CreditCard c = cartaoCreditoConversor.converterDtoToEntity(creditCardDTO);
			userService.validade(c.getUser());
			
			CreditCard creditCard = creditCardRepository.save(c);
			creditCardReturn = cartaoCreditoConversor.converterEntityToDto(creditCard);
		}

		return creditCardReturn;
	}

}
