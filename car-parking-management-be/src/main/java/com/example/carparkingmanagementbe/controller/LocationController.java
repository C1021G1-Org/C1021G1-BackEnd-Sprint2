package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.AllowedCarParking;
import com.example.carparkingmanagementbe.model.Floor;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.service.IFloorsService;
import com.example.carparkingmanagementbe.service.ILocationService;
import com.example.carparkingmanagementbe.service.Impl.AllowedCarParkingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.carparkingmanagementbe.dto.LocationList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private ILocationService iLocationService;

    @Autowired
    private AllowedCarParkingService allowedCarParkingService;

    @Autowired
    private IFloorsService floorsService;
    /*TuanPDCoding*/
    @GetMapping("/{id}")
    public ResponseEntity<?> findLocationByIdDto(@PathVariable Long id) {
        Location location = iLocationService.findLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    /*TuanPDCoding*/
    @PostMapping(value = "/create")
    public ResponseEntity<?> createLocation(@Valid @RequestBody LocationDto locationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_FOUND);
        }
        Location location = new Location();
        BeanUtils.copyProperties(locationDto, location);
        if (locationDto.getId_allowedCarParkingSet() != null) {
            String arrId[] = locationDto.getId_allowedCarParkingSet().split(",");
            Set<AllowedCarParking> allowedCarParkingSet = new HashSet<>();
            for (int i = 0; i < arrId.length; i++) {
                Long id = Long.parseLong(arrId[i]);
                AllowedCarParking allowedCarParking = allowedCarParkingService.getById(id);
                allowedCarParkingSet.add(allowedCarParking);
            }
            location.setAllowedCarParkingSet(allowedCarParkingSet);
            Floor floor = floorsService.findById(locationDto.getId_floor());
            location.setFloor(floor);
        }
        iLocationService.createLocation(location);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /*TuanPDCoding*/
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<?> updateLocation(@Valid @RequestBody LocationDto locationDto, BindingResult bindingResult, @PathVariable(name = "id") Long idLocation) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_FOUND);
        }
        Location location = new Location();
        BeanUtils.copyProperties(locationDto, location);
        if (locationDto.getId_allowedCarParkingSet() != null) {
            String arrId[] = locationDto.getId_allowedCarParkingSet().split(",");
            Set<AllowedCarParking> allowedCarParkingSet = new HashSet<>();
            for (int i = 0; i < arrId.length; i++) {
                Long id = Long.parseLong(arrId[i]);
                AllowedCarParking allowedCarParking = allowedCarParkingService.getById(id);
                allowedCarParkingSet.add(allowedCarParking);
            }
            location.setAllowedCarParkingSet(allowedCarParkingSet);
            Floor floor = floorsService.findById(locationDto.getId_floor());
            location.setFloor(floor);
            location.setId(idLocation);
        }
        iLocationService.editLocation(location);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /*TinhHDCoding*/
    @GetMapping("/list")
    public ResponseEntity<Page<LocationList>> getAllLocation(@RequestParam(defaultValue = "") String code,
                                                             @RequestParam(defaultValue = "") String id,
                                                             @RequestParam(defaultValue = "0") int page) {
        Page<LocationList> locationPage = iLocationService.findAll(code, id, page);
        if (locationPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationPage, HttpStatus.OK);
    }

    /*DatNVNCoding*/
    @GetMapping("/map-parking")
    public ResponseEntity<Page<Location>> getAllLocation(@RequestParam(defaultValue = "0") int page) {
        Page<Location> getAllLocation = iLocationService.getAllLocation(PageRequest.of(page, 86));
        if (getAllLocation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAllLocation, HttpStatus.OK);
    }

    /*DatNVNCoding*/
    @GetMapping("/map-parking/{id}")
    public ResponseEntity<Location> findLocationById(@PathVariable Long id) {
        Location location = iLocationService.findLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    /*DatNVNCoding*/
    @PatchMapping("/update-map-parking/{id}")
    public ResponseEntity<Location> updateColorLocation(@PathVariable Long id) {
        Location location = iLocationService.findLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iLocationService.updateColorLocation(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

}
