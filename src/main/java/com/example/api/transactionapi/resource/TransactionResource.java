package com.example.api.transactionapi.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.api.transactionapi.dto.TransactionDTO;
import com.example.api.transactionapi.service.ITransactionService;

/**
 * This class responsible to provide end point for transactions
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/transactions")
public class TransactionResource extends ResourceBase<TransactionDTO> {

	@Autowired
	private ITransactionService transactionService;

	/**
	 * Method responsible to save transaction in the application
	 * 
	 * @param transactionDTO
	 * @param uriBuilder
	 * @return
	 */
	@PostMapping
	public ResponseEntity<TransactionDTO> save(@RequestBody @Valid TransactionDTO transactionDTO,
			UriComponentsBuilder uriBuilder) {

		TransactionDTO transactionReturnDTO = transactionService.process(transactionDTO);
		String path = "/transactions/{code}";

		return responderItemCriadoComURI(transactionReturnDTO, uriBuilder, path, transactionReturnDTO.getCode());
	}

	/**
	 * Method responsible to list transactions by login
	 * 
	 * @param paginacao
	 * @param login
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<TransactionDTO>> listar(@PageableDefault(page = 0, size = 20) Pageable pageable,
			@RequestParam String login) {

		Page<TransactionDTO> transactions = transactionService.list(pageable, login);
		return responderListaDeItensPaginada(transactions);
	}
}
