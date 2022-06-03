package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.AllowedCarParking;
import com.example.carparkingmanagementbe.repository.AllowedCarParkingRepository;
import com.example.carparkingmanagementbe.service.IAllowedCarParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllowedCarParkingService implements IAllowedCarParkingService {

    @Autowired
    private AllowedCarParkingRepository allowedCarParkingRepository;

    @Override
    public AllowedCarParking getById(Long id) {
        return allowedCarParkingRepository.getById(id);
    }
}
