package com.example.carparkingmanagementbe.service;


import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ILocationService {
    //Tim id cho cac truong thong tin chi tiet vi tri do cua trongTA
   LocationDetailDto findById(Long id);

    //Tìm id cho location của trongTA
    Location findLocationById(Long id);

    //Xoa vi tri do cua trongTA
    void deleteLocationById(Long id);

   //TinhHD code tim list
    Page<LocationList> findAll(String code, String id, int page);
    //Dat suu nhi code tim list
    Page<Location> getAllLocation(Pageable pageable);

    //DatNVN code tim id
    Location findByIdLocation(Long id);

    //DatNVN code update
    void updateColorLocation(Long id);

}
