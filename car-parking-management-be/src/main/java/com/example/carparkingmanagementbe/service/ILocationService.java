package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILocationService {
//    Page<Location> search(String code, Long name, Pageable pageable);

    Page<LocationList> findAll(String code,String id,int page);

    Page<Location> getAllLocation(Pageable pageable);
    Location findLocationById(Long id);
    void updateColorLocation(Long id);
}
