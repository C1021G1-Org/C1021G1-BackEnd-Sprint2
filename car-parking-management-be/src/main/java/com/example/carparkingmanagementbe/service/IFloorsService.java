package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Floor;

public interface IFloorsService {

    Floor findById(Long id);

    Floor findFloorsById(Long id);

}

