package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.model.Location;

import java.util.Optional;

public interface ILocationService {
    //Tim id cho cac truong thong tin chi tiet vi tri do cua trongTA
   LocationDetailDto findById(Long id);

   //tìm id cho location của trongTA
    Location findLocationById(Long id);


    //Xoa vi tri do cuar trongTA
    void deleteLocationById(Long id);

}
