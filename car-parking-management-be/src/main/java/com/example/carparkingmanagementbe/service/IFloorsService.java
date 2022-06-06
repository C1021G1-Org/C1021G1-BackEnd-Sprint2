package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Floor;

import java.util.List;


public interface IFloorsService {


    Floor findById(Long id);

    Floor findFloorsById(Long id);

    List<Floor> findAll();
}

