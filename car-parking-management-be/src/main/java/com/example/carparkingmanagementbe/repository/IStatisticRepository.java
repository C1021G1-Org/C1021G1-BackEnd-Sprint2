package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Price;
import com.example.carparkingmanagementbe.model.Statistic;
import com.example.carparkingmanagementbe.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStatisticRepository extends JpaRepository<Ticket,Long> {
    @Query(value = "SELECT month(start_date) as `time`, sum(sum_price) as sumPrice  from ticket WHERE year(start_date)=?  GROUP BY month(start_date) order by `time` ASC;",nativeQuery = true)
    List<Price> statisticList(int year);
    @Query(value = "SELECT month(start_date) as `time`, sum(sum_price) as sumPrice  from ticket WHERE year(start_date)= :year and month(start_date) between :startMonth and :endMonth GROUP BY month(start_date) order by `time` ASC;",nativeQuery = true)
    List<Price> statisticListByQuarter(@Param("year") int year,@Param("startMonth") int startMonth,@Param("endMonth") int endMonth);
}
