package com.innowise.DudeWhereIsMyCar.DTO.mapers;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.UserResponse;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.UserResponseFull;
import com.innowise.DudeWhereIsMyCar.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toUser(RegisterUserRequest userRequest);
    List<UserResponse> toUserResponse(List<User> users);
    List<UserResponseFull> toUserResponseFull(List<User> users);
    UserResponseFull toUserResponseFull(User users);
    UserResponse toUserResponse(User user);
}
