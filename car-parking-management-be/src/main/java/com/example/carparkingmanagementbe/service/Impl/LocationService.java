package com.example.carparkingmanagementbe.service.Impl;


import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.repository.LocationRepository;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carparkingmanagementbe.dto.LocationList;

import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.AllowedCarParking;

import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.repository.LocationRepository;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.repository.FloorsRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class LocationService implements ILocationService {


    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private FloorsRepository floorsRepository;


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


    /*Find By Id Dùng Chung*/
    @Override
    public Location findLocationById(Long id) {
        return locationRepository.findLocationById(id);
    }

    /*TuanPDCoding*/
    @Override
    public void createLocation(LocationDto locationDto) {
        locationRepository.createLocation(locationDto.getCode(), locationDto.getNumber(), locationDto.getDelFlag(), locationDto.getIsEmpty(), locationDto.getHeight(), locationDto.getLength(), locationDto.getWidth(), locationDto.getDescription(), locationDto.getId_floor());
    }

    /*TuanPDCoding*/
    @Override
    public void editLocation(LocationDto locationDto) {
        locationRepository.editLocationById(locationDto.getHeight(), locationDto.getLength(), locationDto.getWidth(), locationDto.getId());
    }

    /*TuanPDCoding*/
    @Override
    public void editAllowParkingById(Location location) {
        locationRepository.editAllowParkingById(location.getId(), location.getAllowedCarParkingSet());
    }

    /*TuanPDCoding*/
    @Override
    public void createAllowParking(LocationDto locationDto, Set<AllowedCarParking> allowedCarParking) {
        locationRepository.createAllowParking(locationDto.getId_floor(), allowedCarParking);
    }

    /*TinhHDCoding*/
    @Override
    public Page<LocationList> findAll(String code, String id, int page) {
        List<LocationList> locationLists = locationRepository.findByList(code, id);

        Pageable pageableContent = PageRequest.of(page, 5);
        int startPage = (int) pageableContent.getOffset();
        int endPage = Math.min((startPage + pageableContent.getPageSize()), locationLists.size());
        Page<LocationList> locationListPage = new PageImpl<>(locationLists.subList(startPage, endPage), pageableContent, locationLists.size());
        return locationListPage;
    }

    /*DatNVNCoding*/
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


    @Override
    public Page<Location> findAllLocation(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }

}

