package com.example.api.transactionapi.conversor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.example.api.transactionapi.dto.UserDTO;
import com.example.api.transactionapi.model.User;

/**
 * This component responsible to convert entity to DTO and DTO to entity
 * @author j.a.vasconcelos
 *
 */
@Component
public class UserConversor extends ConversorBase<User, UserDTO> {

	@Override
	public UserDTO converterEntityToDto(User entity) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entity, UserDTO.class);
		
	}

	@Override
	public User converterDtoToEntity(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
