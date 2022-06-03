package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Floor;

import java.util.List;

public interface IFloorsService {

    Floor findById(Long id);

    List<Floor> findAll();
}

