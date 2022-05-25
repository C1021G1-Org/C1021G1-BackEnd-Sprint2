package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.Location;

public interface ILocationService {

    /*TuanPDCoding*/
    void createLocation(LocationDto locationDto);

    void editLocation(LocationDto locationDto);

    Location findLocationById(Long id);
    /*TuanPDCoding*/
}
