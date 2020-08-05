package com.example.api.transactionapi.resource.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.api.transactionapi.dto.ErrorDTO;
import com.example.api.transactionapi.dto.UserDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

/**
 * Class responsible to detail User Resource End point
 * 
 * @author j.a.vasconcelos
 *
 */
@Api(value = "/users", description = "Endpoint responsible to maintain users")
public interface IUserResource {

	@ApiOperation(value = "Find balance user by login", nickname = "getBalance", notes = "", response = UserDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "users" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Get balance success", response = UserDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Error request", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "User without access"),
			@ApiResponse(code = 404, message = "User not found") })
	@GetMapping("/{login}/balance")
	public ResponseEntity<UserDTO> getBalance(@PathVariable String login);

	@ApiOperation(value = "Find all contacts by user from login", nickname = "list", notes = "", response = UserDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "users", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "All contacts success", response = UserDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Error request", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "User without access"),
			@ApiResponse(code = 404, message = "User not found") })
	@GetMapping("/contacts")
	public ResponseEntity<List<UserDTO>> list(@RequestParam String login);

	@ApiOperation(value = "Find user by login", nickname = "search", notes = "", response = UserDTO.class, responseContainer = "object", authorizations = {
			@Authorization(value = "basicAuth") }, tags = { "users", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Get user success", response = UserDTO.class, responseContainer = "object"),
			@ApiResponse(code = 400, message = "Error request", response = ErrorDTO.class, responseContainer = "object"),
			@ApiResponse(code = 401, message = "User without access"),
			@ApiResponse(code = 404, message = "User not found") })
	@GetMapping("/{login}")
	public ResponseEntity<UserDTO> search(@PathVariable String login);
}
