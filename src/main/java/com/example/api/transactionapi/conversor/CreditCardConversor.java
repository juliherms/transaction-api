package com.example.api.transactionapi.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.api.transactionapi.dto.CreditCardDTO;
import com.example.api.transactionapi.model.CreditCard;
import com.example.api.transactionapi.service.IUserService;
import com.example.api.transactionapi.utils.CreditCardUtil;

/**
 * 
 * @author j.a.vasconcelos
 *
 */
@Component
public class CreditCardConversor extends ConversorBase<CreditCard, CreditCardDTO> {

	@Autowired
	private IUserService userService;
	
	@Override
	public CreditCardDTO converterEntityToDto(CreditCard entity) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<CreditCard, CreditCardDTO>() {
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entity, CreditCardDTO.class);
	}

	@Override
	public CreditCard converterDtoToEntity(CreditCardDTO dto) {
		
		return CreditCard
				.builder()
				.flag(dto.getFlag())
				.number(CreditCardUtil.mask(dto.getNumber()))
				.tokenNumber(dto.getTokenNumber())
				.user(userService.find(dto.getUser().getLogin()))
				.build();
	}

}
