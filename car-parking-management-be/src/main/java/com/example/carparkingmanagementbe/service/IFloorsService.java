package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Floor;
import com.example.carparkingmanagementbe.model.Location;

public interface IFloorsService {
    Floor findFloorsById(Long id);
}
