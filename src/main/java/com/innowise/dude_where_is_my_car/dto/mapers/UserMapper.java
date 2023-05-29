package com.innowise.dude_where_is_my_car.dto.mapers;

import com.innowise.dude_where_is_my_car.dto.requests.user_requests.RegisterUserRequest;
import com.innowise.dude_where_is_my_car.dto.responses.UserResponse;
import com.innowise.dude_where_is_my_car.dto.responses.UserResponseFull;
import com.innowise.dude_where_is_my_car.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    User toUser(RegisterUserRequest userRequest);

    List<UserResponse> toUserResponse(List<User> users);

    List<UserResponseFull> toUserResponseFull(List<User> users);

    UserResponseFull toUserResponseFull(User users);

    UserResponse toUserResponse(User user);
}
