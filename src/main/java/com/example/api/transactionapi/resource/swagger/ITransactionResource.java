package com.example.api.transactionapi.resource.swagger;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.api.transactionapi.dto.ErrorDTO;
import com.example.api.transactionapi.dto.TransactionDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 * Class responsible to detail Transaction Resource End point
 * 
 * @author j.a.vasconcelos
 *
 */
@Api(value = "/transactions", description = "Endpoint responsible to maintain transactions")
public interface ITransactionResource {

	@ApiOperation(value = "Save transaction", nickname = "save", notes = "", response = TransactionDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "transactions" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Save transaction success", response = TransactionDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Error request", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "User without access"),
			@ApiResponse(code = 404, message = "method not found") })
	@PostMapping
	public ResponseEntity<TransactionDTO> save(@RequestBody @Valid TransactionDTO transactionDTO,
			UriComponentsBuilder uriBuilder);
	
	@ApiOperation(value = "List Transactions", nickname = "list", notes = "", response = TransactionDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "transactions" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List transaction success", response = TransactionDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Error request", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "User without access"),
			@ApiResponse(code = 404, message = "method not found") })
	@GetMapping
	public ResponseEntity<Page<TransactionDTO>> listar(@PageableDefault(page = 0, size = 20) Pageable pageable,
			@RequestParam String login);

}
