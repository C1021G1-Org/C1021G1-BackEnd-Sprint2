package com.example.carparkingmanagementbe.service;


import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.dto.LocationList;

import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.AllowedCarParking;

import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.dto.LocationList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;
import java.util.Optional;

public interface ILocationService {


    List<Location> getListLocation(Long idFloor);

    List<Location> findAll();


    //Tim id cho cac truong thong tin chi tiet vi tri do cua trongTA
    LocationDetailDto findById(Long id);

    /*Find By Id Dùng Chung*/
    Location findLocationById(Long id);

    /*TuanPDCoding*/
    void createLocation(Location location);


    void editLocation(Location location);

    /*TuanPDCoding*/

    //Xoa vi tri do cua trongTA
    void deleteLocationById(Long id);

    //TinhHD code tim list
    Page<LocationList> findAll(String code, String id, int page);

    //Dat suu nhi code tim list
    Page<Location> getAllLocation(Pageable pageable);


    //DatNVN code update
    void updateColorLocation(Long id);

    //DatNVN search
    Page<Location> searchLocationCode(String code, Pageable pageable);


    //DatNVN code tim id
    Location findByIdLocation(Long id);


    Page<Location> findAllLocation(Pageable pageable);

    Location findByTicket(Long id);
}
