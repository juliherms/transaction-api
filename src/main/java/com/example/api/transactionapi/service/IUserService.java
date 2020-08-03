package com.example.api.transactionapi.service;

import java.util.List;

import com.example.api.transactionapi.dto.UserDTO;
import com.example.api.transactionapi.model.Transaction;
import com.example.api.transactionapi.model.User;

/**
 * This class represent user service
 * 
 * @author j.a.vasconcelos
 *
 */
public interface IUserService {

	User find(String login);

	UserDTO findByLogin(String login);

	void updateBalance(Transaction transaction, Boolean isCreditCard);

	void validade(User... users);

	List<UserDTO> list(String login);

}
