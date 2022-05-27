package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.CarType;

import java.util.List;

public interface ICarTypeService {
    List<CarType> findAll();
}
