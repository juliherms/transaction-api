package com.example.api.transactionapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.transactionapi.model.CreditCard;

/**
 * This class represents CreditCard repository
 * @author j.a.vasconcelos
 *
 */
public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

}

