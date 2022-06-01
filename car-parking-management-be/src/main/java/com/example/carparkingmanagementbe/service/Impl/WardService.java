package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Ward;
import com.example.carparkingmanagementbe.repository.WardRepository;
import com.example.carparkingmanagementbe.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardService implements IWardService {
    @Autowired
    private WardRepository wardRepository;
    @Override
    public List<Ward> getAllWard(Long id) {
        return wardRepository.getAllWard(id);
    }

    @Override
    public Optional<Ward> findWardById(Long id) {
        return wardRepository.findById(id);
    }
}
