package com.example.api.transactionapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.api.transactionapi.model.User;

/**
 * This class represent user repository
 * @author j.a.vasconcelos
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
	 * Return User by login
	 * @param login
	 * @return
	 */
	User findByLogin(String login);
	
	/**
	 * Responsible to debit balance from user.
	 * @param login
	 * @param value
	 */
	@Modifying
	@Query("update User u set u.balance = u.balance - ?2 where u.login = ?1")
	void updateDecrementBalance(String login, Double value);
	
	/**
	 * Responsible to credit balance from user
	 * @param login
	 * @param value
	 */
	@Modifying
	@Query("update User u set u.balance = u.balance + ?2 where u.login = ?1")
	void updateIncrementBalance(String login, Double value);
}
