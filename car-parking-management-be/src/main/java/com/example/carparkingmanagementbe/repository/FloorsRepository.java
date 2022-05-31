package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorsRepository extends JpaRepository<Floor, Long> {
}
