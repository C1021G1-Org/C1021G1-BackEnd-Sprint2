package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Ward;
import com.example.carparkingmanagementbe.repository.WardRepository;
import com.example.carparkingmanagementbe.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService implements IWardService {
    @Autowired
    private WardRepository wardRepository;
    @Override
    public List<Ward> getAllWard() {
        return wardRepository.getAllWard();
    }

    @Override
    public List<Ward> getWardById(Long id) {
        return wardRepository.getWardById(id);
    }
}
