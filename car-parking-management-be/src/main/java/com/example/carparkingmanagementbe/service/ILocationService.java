package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Location;

import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ILocationService {

    List<Location> getListLocation(Long idFloor);

    List<Location> findAll();




}
