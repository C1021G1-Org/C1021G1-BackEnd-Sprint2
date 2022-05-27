package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.District;
import com.example.carparkingmanagementbe.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {
    @Query(value = "SELECT district.id,district.name,district.prefix,district.id_province " +
            "FROM district " +
            "where district.id_province = ?;", nativeQuery = true)
    List<District> getAllDistrict(Long id);
}
