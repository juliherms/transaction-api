package com.example.api.transactionapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.transactionapi.dto.UserDTO;
import com.example.api.transactionapi.service.IUserService;

/**
 * This class responsible to provide services for users
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/users")
public class UserResource extends ResourceBase<UserDTO>{

	@Autowired
	private IUserService userService;

	
	@GetMapping("/{login}/balance")
	public ResponseEntity<UserDTO> getBalance(@PageableDefault(page = 0, size = 20) Pageable paginacao,
			@PathVariable String login) {

		UserDTO usuarioDTO = userService.findByLogin(login);
		return resourceCreadtedWithItem(usuarioDTO);
	}
	
	@GetMapping("/contacts")
	public ResponseEntity<List<UserDTO>> list(@RequestParam String login) {
		List<UserDTO> usuarios = userService.list(login);
		return responderListaDeItens(usuarios);
	}

}
