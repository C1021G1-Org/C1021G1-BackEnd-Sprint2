package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Floor;
import com.example.carparkingmanagementbe.repository.FloorsRepository;
import com.example.carparkingmanagementbe.service.IFloorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorsService implements IFloorsService {

    @Autowired
    private FloorsRepository floorsRepository;


    @Override
    public Floor findById(Long id) {
        return floorsRepository.findById(id).orElse(null);
    }

    @Override

    public List<Floor> findAll() {
        return floorsRepository.findAll();
    }

    public Floor findFloorsById(Long id) {
        return floorsRepository.findById(id).orElse(null);
    }



}
