package com.example.carparkingmanagementbe.service;
import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.model.Floor;
import com.example.carparkingmanagementbe.model.Location;

import java.util.List;

public interface IFloorsService {
    Floor findFloorsById(Long id);

    List<Floor> findAll();

}

