package com.example.api.transactionapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.transactionapi.dto.UserDTO;
import com.example.api.transactionapi.resource.swagger.IUserResource;
import com.example.api.transactionapi.service.IUserService;

/**
 * This class responsible to provide services for users
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/users")
public class UserResource extends ResourceBase<UserDTO>implements IUserResource {


	@Autowired
	private IUserService userService;

	/**
	 * Method responsible to get actual balance from user
	 * 
	 * @param paginacao
	 * @param login
	 * @return
	 */
	@GetMapping("/{login}/balance")
	public ResponseEntity<UserDTO> getBalance(@PathVariable String login) {

		UserDTO usuarioDTO = userService.findByLogin(login);
		return resourceCreadtedWithItem(usuarioDTO);
	}

	/**
	 * Method responsible to list contacts from login
	 * 
	 * @param login
	 * @return
	 */
	@GetMapping("/contacts")
	public ResponseEntity<List<UserDTO>> list(@RequestParam String login) {
		List<UserDTO> usuarios = userService.list(login);
		return resouceListOfItems(usuarios);
	}

	/**
	 * Method responsible to find user by login
	 * 
	 * @param login
	 * @return
	 */
	@GetMapping("/{login}")
	public ResponseEntity<UserDTO> search(@PathVariable String login) {
		UserDTO usuario = userService.findByLogin(login);
		return resourceCreadtedWithItem(usuario);
	}

}
