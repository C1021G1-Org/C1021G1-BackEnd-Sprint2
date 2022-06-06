package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.repository.LocationRepository;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carparkingmanagementbe.dto.LocationList;
import org.springframework.data.domain.*;

import java.util.List;


@Service
public class LocationService implements ILocationService {


    @Autowired
    private LocationRepository locationRepository;


    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    //Trong tim id detail
    @Override
    public LocationDetailDto findById(Long id) {
        return locationRepository.findLocationsById(id);
    }

    @Override
    public List<Location> getListLocation(Long idFloor) {
        return locationRepository.getListLocation(idFloor);
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

    /*DatNVNCoding*/
    @Override
    public Page<Location> getAllLocation(Pageable pageable) {
        return locationRepository.getAllLocation(pageable);
    }

    //dat code
    @Override
    public void updateColorLocation(Long id) {
        locationRepository.updateIsEmpty(id);
    }

    //Datnvn
    @Override
    public Page<Location> searchLocationCode(String code, Pageable pageable) {
        return locationRepository.searchLocationCode(code, pageable);
    }

    @Override
    public Page<Location> findAllLocation(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }


}