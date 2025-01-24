package com.ideabazaar.user.userserviceapi.mapper;

import com.ideabazaar.user.userserviceapi.dto.UserDTO;
import com.ideabazaar.user.userserviceapi.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Map fields from User -> UserDto
    UserDTO userToUserDto(User user);

    // Map fields from UserDto -> User
    @Mapping(target = "passwordHash", ignore = true)
    User userDtoToUser(UserDTO userDto);



}