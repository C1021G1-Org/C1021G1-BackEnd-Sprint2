package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Position;
import com.example.carparkingmanagementbe.repository.PositionRepository;
import com.example.carparkingmanagementbe.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.getAllPosition();
    }
}
