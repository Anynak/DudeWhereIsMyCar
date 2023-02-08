package com.innowise.DudeWhereIsMyCar.user;

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
