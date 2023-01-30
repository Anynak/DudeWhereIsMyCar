package com.innowise.DudeWhereIsMyCar.Mappers;

import com.innowise.DudeWhereIsMyCar.dto.request.RegisterUserRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.UserResponse;
import com.innowise.DudeWhereIsMyCar.dto.response.UserResponseFull;
import com.innowise.DudeWhereIsMyCar.entity.User;
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
