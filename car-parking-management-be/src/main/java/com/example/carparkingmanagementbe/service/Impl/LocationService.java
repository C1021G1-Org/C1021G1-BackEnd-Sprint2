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
    private LocationRepository locationRepository;

    @Autowired
    private FloorsRepository floorsRepository;

    /*Find By Id Dùng Chung*/
    @Override
    public Location findLocationById(Long id) {
        return locationRepository.findLocationById(id);
    }
    /*Find By Id Dùng Chung*/

    /*TuanPDCoding*/
    @Override
    public void createLocation(Location location) {
        locationRepository.save(location);
    }

    /*TuanPDCoding*/
    @Override
    public void editLocation(Location location) {
        locationRepository.save(location);
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
    /*TinhHDCoding*/

    /*DatNVNCoding*/
    @Override
    public Page<Location> getAllLocation(Pageable pageable) {
        return locationRepository.getAllLocation(pageable);
    }

    @Override
    public void updateColorLocation(Long id) {
        locationRepository.updateIsEmpty(id);
    }
    /*DatNVNCoding*/
}
