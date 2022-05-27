package com.example.carparkingmanagementbe.service.Impl;

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
    @Autowired
    private FloorsRepository floorsRepository;
//    @Override
//    public Page<Location> search(String code, Long name, Pageable pageable) {
//        return null;
//    }
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

    @Override
    public Location findLocationById(Long id) {
        return locationRepository.findLocationById(id);
    }

    @Override
    public void updateColorLocation(Long id) {
        locationRepository.updateIsEmpty(id);
    }

    @Override
    public Page<Location> findAllLocation(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }
}
