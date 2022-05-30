package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {

    @Query(value = "SELECT id,name,prefix FROM province;", nativeQuery = true)
    List<Province> getAllProvince();
}