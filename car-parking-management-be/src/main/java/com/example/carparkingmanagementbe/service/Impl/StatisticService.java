package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.MinMax;
import com.example.carparkingmanagementbe.model.Price;
import com.example.carparkingmanagementbe.repository.IStatisticRepository;
import com.example.carparkingmanagementbe.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService implements IStatisticService {
    @Autowired
    IStatisticRepository statisticRepository;
    @Override
    public List<Price> getListStatistic(int year) {
        return statisticRepository.statisticList(year);
    }

    @Override
    public List<Price> getListStatisticByQuarter(int year,int start,int end) {
        return statisticRepository.statisticListByQuarter(year, start, end);
    }

    @Override
    public MinMax getMinMaxYear() {
        return statisticRepository.getMinMaxYear();
    }
}
