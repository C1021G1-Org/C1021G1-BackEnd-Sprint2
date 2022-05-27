package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType,Long> {

    //TrongHD lấy thông tin loại xe
    @Query(value = "SELECT id, name, price FROM car_type", nativeQuery = true )
    List<CarType> findAllCarType();
}
