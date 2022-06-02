package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Province;
import com.example.carparkingmanagementbe.repository.ProvinceRepository;
import com.example.carparkingmanagementbe.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public List<Province> getAllProvince() {
        return provinceRepository.getAllProvince();
    }
}
