package com.innowise.DudeWhereIsMyCar.service.impl;


import com.innowise.DudeWhereIsMyCar.exceptions.ResourceNotFoundException;
import com.innowise.DudeWhereIsMyCar.models.Role;
import com.innowise.DudeWhereIsMyCar.repositories.RoleRepository;
import com.innowise.DudeWhereIsMyCar.service.RoleService;
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
