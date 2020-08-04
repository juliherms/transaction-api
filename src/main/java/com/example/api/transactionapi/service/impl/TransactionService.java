package com.example.api.transactionapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.transactionapi.conversor.TransactionConversor;
import com.example.api.transactionapi.dto.TransactionDTO;
import com.example.api.transactionapi.model.Transaction;
import com.example.api.transactionapi.repository.TransactionRepository;
import com.example.api.transactionapi.service.ICreditCardService;
import com.example.api.transactionapi.service.ITransactionService;
import com.example.api.transactionapi.service.IUserService;

/**
 * This class responsible to services of transaction
 * 
 * @author j.a.vasconcelos
 *
 */
@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private TransactionConversor transactionConversor;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ICreditCardService creditCardService;

	@Autowired
	private IUserService userService;

	/**
	 * Method responsible to process transaction
	 * save transaction
	 * save credit card
	 * update balance
	 * @param dto
	 * @return
	 */
	@Override
	public TransactionDTO process(TransactionDTO dto) {

		Transaction t = this.save(dto);
		creditCardService.save(dto.getCreditCardDTO());
		userService.updateBalance(t, dto.getIsCreditCard());
		return transactionConversor.converterEntityToDto(t);
	}

	/**
	 * Method responsible to save transaction in the application.
	 * @param transactionDTO
	 * @return
	 */
	private Transaction save(TransactionDTO transactionDTO) {

		Transaction t = transactionConversor.converterDtoToEntity(transactionDTO);
		userService.validade(t.getUserSource(), t.getUserDestinity());
		return transactionRepository.save(t);
	}

	/**
	 * Method responsible to return list transaction for user
	 */
	@Override
	public Page<TransactionDTO> list(Pageable pageable, String user) {
		
		Page<Transaction> transactions = transactionRepository.findByUserSource_LoginOrUserDestinity_Login(user, user, pageable);
		return transactionConversor.converterPageEntityTiDto(transactions);
	}

}
