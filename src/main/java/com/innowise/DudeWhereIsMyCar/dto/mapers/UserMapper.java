package com.innowise.DudeWhereIsMyCar.dto.mapers;

import com.innowise.DudeWhereIsMyCar.dto.requests.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.UserResponse;
import com.innowise.DudeWhereIsMyCar.dto.responses.UserResponseFull;
import com.innowise.DudeWhereIsMyCar.models.User;
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