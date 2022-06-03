package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.AllowedCarParking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllowedCarParkingRepository extends JpaRepository<AllowedCarParking, Long> {


}
