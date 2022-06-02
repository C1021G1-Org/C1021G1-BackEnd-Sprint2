package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Price;
import com.example.carparkingmanagementbe.model.Statistic;
import com.example.carparkingmanagementbe.model.SumStatistic;
import com.example.carparkingmanagementbe.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Controller
public class StatisticController {
    @Autowired
    IStatisticService statisticService;
    List<Price> priceList;
    List<SumStatistic> sumStatistics;
    @PostMapping(value = "/api/statistic")
    public ResponseEntity<?> statistic(@RequestBody Statistic statistic){
        int sum = 0;
        sumStatistics = new ArrayList<>();
        SumStatistic sumStatistic;
        if(statistic.getQuarter()==0){
            priceList = statisticService.getListStatistic(statistic.getYear());
            for(int i =0;i<12;i++){
                sumStatistics.add(new SumStatistic(0,i+1));
            }
        }else {
            for(int i =0;i<3;i++){
                sumStatistics.add(new SumStatistic(0,3*(statistic.getQuarter()-1)+1+i));
            }
            priceList = statisticService.getListStatisticByQuarter(statistic.getYear(),3*(statistic.getQuarter()-1)+1,3*(statistic.getQuarter()-1)+3);
        }
        for(Price price : priceList){
            sum += price.getSumPrice();
        }
        for(int i = 0;i< priceList.size();i++){
            sumStatistic =  new SumStatistic();
            sumStatistic.setSumPrice(priceList.get(i).getSumPrice()*10000/sum);
            sumStatistic.setTime(sumStatistics.get(i).getTime());
            System.out.println(priceList.get(i).getSumPrice()*10000/sum);
            if(sum!=0){
                System.out.println(123);
                sumStatistics.get(priceList.get(i).getTime()-1).setSumPrice(priceList.get(i).getSumPrice()*10000/sum);
            }

        }
        return new ResponseEntity<>(sumStatistics,HttpStatus.OK);
    }
    @GetMapping("/home")
    public ResponseEntity<?> home(){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
