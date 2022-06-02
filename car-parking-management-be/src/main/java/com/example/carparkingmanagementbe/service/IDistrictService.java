package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.District;

import java.util.List;
import java.util.Optional;

public interface IDistrictService {
    List<District> getAllDistrict();

    List<District> getDistrictById(Long id);
}
