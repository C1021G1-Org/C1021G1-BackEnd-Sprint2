package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Ward;

import java.util.List;
import java.util.Optional;

public interface IWardService {
    List<Ward> getAllWard();
    List<Ward> getWardById(Long id);

}
