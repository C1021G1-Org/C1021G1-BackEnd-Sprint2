package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Floor;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.repository.FloorsRepository;
import com.example.carparkingmanagementbe.service.IFloorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorsService implements IFloorsService {
@Autowired
private FloorsRepository repository;
    @Override
    public Floor findFloorsById(Long id) {
        return repository.findById(id).orElse(null) ;
    }
}
