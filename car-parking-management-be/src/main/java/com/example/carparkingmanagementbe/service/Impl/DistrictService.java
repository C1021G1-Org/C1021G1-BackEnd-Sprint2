package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.District;
import com.example.carparkingmanagementbe.repository.DistrictRepository;
import com.example.carparkingmanagementbe.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService implements IDistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    @Override
    public List<District> getAllDistrict(Long id) {
        return districtRepository.getAllDistrict(id);
    }
}
