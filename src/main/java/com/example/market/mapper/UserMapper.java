package com.example.market.mapper;

import com.example.market.dtos.response.UserResponse;
import com.example.market.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);
}
