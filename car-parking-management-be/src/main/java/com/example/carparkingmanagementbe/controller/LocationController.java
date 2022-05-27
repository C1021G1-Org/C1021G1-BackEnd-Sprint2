package com.example.carparkingmanagementbe.controller;


import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.AllowedCarParking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private ILocationService iLocationService;

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
    public ResponseEntity<?> createLocation(@Valid @RequestBody LocationDto locationDto, Set<AllowedCarParking> allowedCarParking, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_FOUND);
        }
        iLocationService.createLocation(locationDto);
        iLocationService.createAllowParking(locationDto, allowedCarParking);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /*TuanPDCoding*/
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<?> updateLocation(@Valid @RequestBody LocationDto locationDto, Location location, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_FOUND);
        }
        iLocationService.editLocation(locationDto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    /*TinhHDCoding*/
    @GetMapping("/list")
    public ResponseEntity<Page<LocationList>> getAllLocation(@RequestParam(defaultValue = "") String code,
                                                             @RequestParam(defaultValue = "") String id,
                                                             @RequestParam(defaultValue = "0") int page) {
        Page<LocationList> locationPage = iLocationService.findAll(code, id, page);

        System.out.println(locationPage.getTotalPages());
        if(locationPage.getTotalPages()<=page){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if (locationPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationPage, HttpStatus.OK);
    }

    // dat code
    @GetMapping("/map-parking")
    public ResponseEntity<Page<Location>> getAllLocation(@RequestParam(defaultValue = "0") int page) {
        Page<Location> getAllLocation = iLocationService.getAllLocation(PageRequest.of(page, 86));
        if (getAllLocation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAllLocation, HttpStatus.OK);
    }

    // dat code
    @GetMapping("/map-parking/{id}")
    public ResponseEntity<Location> findLocationById(@PathVariable Long id) {
        Location location = iLocationService.findLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);

    }

    @GetMapping("/listMapParking")
    public ResponseEntity<Page<Location>> listAllLocation(Pageable pageable) {
        Page<Location> location = iLocationService.findAllLocation(pageable);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    // dat code update
    @DeleteMapping("/update-map-parking/{id}")
    public ResponseEntity<Location> updateColorLocation(@PathVariable Long id) {
        Location location = iLocationService.findLocationById(id);
        System.out.println(location.getIsEmpty());
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iLocationService.updateColorLocation(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // detail location parking TrongTa
    @GetMapping("/detail/{id}")
    public ResponseEntity<LocationDetailDto> getId(@PathVariable Long id) {
        LocationDetailDto location = iLocationService.findById(id);

        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(location, HttpStatus.OK);
        }

    }

    //xóa location trongTa
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        Location location = iLocationService.findLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (location.getIsEmpty()) {
            Map<String, String> error = new HashMap<>();
            error.put("isEmpty", "vi tri nay dang co nguoi dau xe khong the xoa");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
        iLocationService.deleteLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }


}




