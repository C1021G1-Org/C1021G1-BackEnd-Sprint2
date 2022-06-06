package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.MinMax;
import com.example.carparkingmanagementbe.model.Price;

import java.util.List;

public interface IStatisticService {
    List<Price> getListStatistic(int year);
    List<Price> getListStatisticByQuarter(int year,int start, int end);

    MinMax getMinMaxYear();
}
