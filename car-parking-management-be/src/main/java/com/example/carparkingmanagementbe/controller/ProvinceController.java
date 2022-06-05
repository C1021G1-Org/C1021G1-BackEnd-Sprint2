package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Province;
import com.example.carparkingmanagementbe.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/province")
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/province-list")
    public ResponseEntity<List<Province>> getAllProvince() {
        List<Province> provinceList = provinceService.getAllProvince();
        if (provinceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList,HttpStatus.OK);
    }
}
