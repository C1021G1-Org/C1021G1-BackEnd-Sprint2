package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.repository.LocationRepository;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getListLocation(Long idFloor) {
        return locationRepository.getListLocation(idFloor);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
