package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Role;
import com.example.carparkingmanagementbe.repository.RoleRepository;
import com.example.carparkingmanagementbe.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role findById(long l) {
        return roleRepository.getById(l);
    }
}
