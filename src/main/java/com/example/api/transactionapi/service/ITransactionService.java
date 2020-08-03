package com.example.api.transactionapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.api.transactionapi.dto.TransactionDTO;

/**
 * This class responsible to Transaction Service
 * @author j.a.vasconcelos
 *
 */
public interface ITransactionService {

	TransactionDTO process(TransactionDTO transacaoDTO);

	Page<TransactionDTO> list(Pageable paginacao, String user);

}
