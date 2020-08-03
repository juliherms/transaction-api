package com.example.api.transactionapi.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.api.transactionapi.constants.MessageValidation;
import com.example.api.transactionapi.conversor.UserConversor;
import com.example.api.transactionapi.dto.UserDTO;
import com.example.api.transactionapi.exception.BusinessException;
import com.example.api.transactionapi.model.Transaction;
import com.example.api.transactionapi.model.User;
import com.example.api.transactionapi.repository.UserRepository;
import com.example.api.transactionapi.service.IUserService;

/**
 * This classes responsible to implement userService
 * 
 * @author j.a.vasconcelos
 *
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConversor userConversor;

	@Override
	@Transactional
	public User find(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public UserDTO findByLogin(String login) {
		User user = find(login);
		return userConversor.converterEntityToDto(user);
	}

	@Override
	@Async("asyncExecutor")
	@Transactional
	public void updateBalance(Transaction transaction, Boolean isCreditCard) {

		this.decreeBalance(transaction, isCreditCard);
		this.incrementBalance(transaction);
	}

	@Override
	public void validade(User... users) {

		Arrays.asList(users).stream().forEach(user -> {
			if (user == null) {
				throw new BusinessException(MessageValidation.ERROR_USER_NOT_EXISTS);
			}
		});
	}

	@Override
	public List<UserDTO> list(String login) {

		List<User> users = userRepository.findAll();
		return userConversor.converterEntitiesToDtos(
				users.stream().filter(v -> !v.getLogin().equals(login)).collect(Collectors.toList()));
	}

	private void incrementBalance(Transaction transaction) {
		userRepository.updateIncrementBalance(transaction.getUserDestinity().getLogin(), transaction.getValue());
	}

	private void decreeBalance(Transaction transaction, Boolean isCreditCard) {
		if (!isCreditCard) {
			userRepository.updateDecrementBalance(transaction.getUserSource().getLogin(), transaction.getValue());
		}
	}

}
