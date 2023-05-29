package com.innowise.dude_where_is_my_car.service.impl;


import com.innowise.dude_where_is_my_car.exceptions.ResourceNotFoundException;
import com.innowise.dude_where_is_my_car.models.Role;
import com.innowise.dude_where_is_my_car.repositories.RoleRepository;
import com.innowise.dude_where_is_my_car.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByRoleName(name).orElseThrow(() -> new ResourceNotFoundException("role with name " + name + " not found"));
    }
}
