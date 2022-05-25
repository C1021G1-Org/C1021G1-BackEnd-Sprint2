package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.repository.LocationRepository;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private LocationRepository repository;

    /*TuanPDCoding*/
    @Override
    public void createLocation(LocationDto locationDto) {
    }

    @Override
    public void editLocation(LocationDto locationDto) {
        repository.editLocationById(locationDto.getHeight(), locationDto.getLength(), locationDto.getWidth(), locationDto.getId());
    }

    @Override
    public Location findLocationById(Long id) {
        return repository.findLocationById(id);
    }
    /*TuanPDCoding*/

}
