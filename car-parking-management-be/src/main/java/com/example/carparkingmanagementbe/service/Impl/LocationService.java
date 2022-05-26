package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.repository.LocationRepository;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private LocationRepository repository;


    @Override
    public LocationDetailDto findById(Long id) {
        return repository.findLocationsById(id);
    }

    @Override
    public Location findLocationById(Long id) {
        return repository.findLocationById(id);
    }


    @Override
    public void deleteLocationById(Long id) {
        repository.removeLocationById(id);
    }
}
