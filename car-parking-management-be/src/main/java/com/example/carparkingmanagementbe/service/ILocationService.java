package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.AllowedCarParking;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.dto.LocationList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface ILocationService {

    /*Find By Id Dùng Chung*/
    Location findLocationById(Long id);
    /*Find By Id Dùng Chung*/

    /*TuanPDCoding*/
    void createLocation(LocationDto locationDto);

    void editLocation(LocationDto locationDto);

    void editAllowParkingById(Location location);

    void createAllowParking(LocationDto locationDto, Set<AllowedCarParking> allowedCarParking);
    /*TuanPDCoding*/

    Page<LocationList> findAll(String code,String id,int page);

    Page<Location> getAllLocation(Pageable pageable);

    void updateColorLocation(Long id);

}
