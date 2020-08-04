package com.example.api.transactionapi.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.api.transactionapi.dto.TransactionDTO;
import com.example.api.transactionapi.model.Transaction;
import com.example.api.transactionapi.service.IUserService;

/**
 * Class responsible to convert Transaction to TransactionDTO
 * 
 * @author j.a.vasconcelos
 *
 */
@Component
public class TransactionConversor extends ConversorBase<Transaction, TransactionDTO> {

	@Autowired
	private IUserService userService;

	@Override
	public TransactionDTO converterEntityToDto(Transaction entity) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Transaction, TransactionDTO>() {
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entity, TransactionDTO.class);
	}

	@SuppressWarnings("unchecked")
	public Page<TransactionDTO> converterPageEntityTiDto(Page<Transaction> entity) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Page<Transaction>, Page<TransactionDTO>>() {
			@Override
			protected void configure() {
			}
		});

		return modelMapper.map(entity, Page.class);
	}

	@Override
	public Transaction converterDtoToEntity(TransactionDTO dto) {

		return Transaction.builder().code(dto.getCode()).dateTime(dto.getDateAndHour()).value(dto.getValue())
				.userDestinity(userService.find(dto.getDestiny().getLogin()))
				.userSource(userService.find(dto.getSource().getLogin())).build();
	}

}
