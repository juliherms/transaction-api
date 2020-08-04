package com.example.api.transactionapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.transactionapi.model.Transaction;

/**
 * This class responsible to Transaction Repository
 * 
 * @author j.a.vasconcelos
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Page<Transaction> findByUserSource_LoginOrUserDestinity_Login(String loginOrigem, String loginDestino,
			Pageable pageable);

}
