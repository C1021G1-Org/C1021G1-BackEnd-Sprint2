package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.repository.LocationRepository;
import com.example.carparkingmanagementbe.service.IFloorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorsService implements IFloorsService {

    @Autowired
    private LocationRepository repository;


    @Override
    public void createLocation(LocationDto locationDto) {

    }

    @Override
    public void editLocation(LocationDto locationDto) {

    }
}
