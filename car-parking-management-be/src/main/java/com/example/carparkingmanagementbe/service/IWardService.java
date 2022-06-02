package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Ward;

import java.util.List;


public interface IWardService {
    List<Ward> getAllWard();
    List<Ward> getWardById(Long id);

}
