package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.CarType;
import com.example.carparkingmanagementbe.repository.CarTypeRepository;
import com.example.carparkingmanagementbe.service.ICarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeService implements ICarTypeService {

    @Autowired
    private CarTypeRepository carTypeRepository;

    @Override
    public List<CarType> findAll() {
        return carTypeRepository.findAllCarType();
    }
}
