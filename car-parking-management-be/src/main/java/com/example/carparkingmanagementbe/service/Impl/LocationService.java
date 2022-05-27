package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.repository.LocationRepository;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.repository.FloorsRepository;
import com.example.carparkingmanagementbe.repository.LocationRepository;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private LocationRepository locationRepository;

    //Trong tim id detail
    @Override
    public LocationDetailDto findById(Long id) {
        return locationRepository.findLocationsById(id);
    }


    //Trong tim id delete
    @Override
    public void deleteLocationById(Long id) {
        locationRepository.removeLocationById(id);
    }
    //Trong tim id Xoa
    @Override
    public Location findLocationById(Long id) {
        return locationRepository.findLocationById(id);
    }


    // TinhHD code list
    @Override
    public Page<LocationList> findAll(String code,String id,int page) {
        List<LocationList> locationLists = locationRepository.findByList(code,id);
        Pageable pageableContent = PageRequest.of(page, 5);
        int startPage = (int) pageableContent.getOffset();
        int endPage = Math.min((startPage + pageableContent.getPageSize()), locationLists.size());
        Page<LocationList> locationListPage = new PageImpl<>(locationLists.subList(startPage, endPage), pageableContent, locationLists.size());
        return locationListPage;
    }
    //dat code
    @Override
    public Page<Location> getAllLocation(Pageable pageable) {
        return locationRepository.getAllLocation(pageable);
    }
    //dat code
    @Override
    public Location findByIdLocation(Long id) {
        return locationRepository.findByIdLocation(id);
    }
    //dat code
    @Override
    public void updateColorLocation(Long id) {
        locationRepository.updateIsEmpty(id);
    }
}
