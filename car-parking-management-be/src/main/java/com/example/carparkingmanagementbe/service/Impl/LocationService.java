package com.example.carparkingmanagementbe.service.Impl;

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
    private LocationRepository repository;

    @Autowired
    private FloorsRepository floorsRepository;

    /*Find By Id Dùng Chung*/
    @Override
    public Location findLocationById(Long id) {
        return repository.findLocationById(id);
    }
    /*Find By Id Dùng Chung*/

    /*TuanPDCoding*/
    @Override
    public void createLocation(LocationDto locationDto) {
        repository.createLocation(locationDto.getCode(), locationDto.getNumber(), locationDto.getDelFlag(), locationDto.getIsEmpty(), locationDto.getHeight(), locationDto.getLength(), locationDto.getWidth(), locationDto.getDescription(), locationDto.getId_floor());
    }

    @Override
    public void editLocation(LocationDto locationDto) {
        repository.editLocationById(locationDto.getHeight(), locationDto.getLength(), locationDto.getWidth(), locationDto.getId());
    }

    @Override
    public void editAllowParkingById(Location location) {
        repository.editAllowParkingById(location.getId(), location.getAllowedCarParkingSet());
    }

    @Override
    public void createAllowParking(LocationDto locationDto, Set<AllowedCarParking> allowedCarParking) {
        repository.createAllowParking(locationDto.getId_floor(), allowedCarParking);
    }
    /*TuanPDCoding*/

    /*TinhHDCoding*/
    @Override
    public Page<LocationList> findAll(String code, String id, int page) {
        List<LocationList> locationLists = repository.findByList(code, id);
        Pageable pageableContent = PageRequest.of(page, 5);
        int startPage = (int) pageableContent.getOffset();
        int endPage = Math.min((startPage + pageableContent.getPageSize()), locationLists.size());
        Page<LocationList> locationListPage = new PageImpl<>(locationLists.subList(startPage, endPage), pageableContent, locationLists.size());
        return locationListPage;
    }
    /*TinhHDCoding*/
}
