package com.example.carparkingmanagementbe.service;
import com.example.carparkingmanagementbe.model.Ward;
import java.util.List;

public interface IWardService {

    Ward findWardById(Long id);
    List<Ward> getAllWard();
    List<Ward> getWardById(Long id);
}
