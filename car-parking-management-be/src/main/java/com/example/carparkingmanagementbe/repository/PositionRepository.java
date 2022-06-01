package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    @Query(value = "SELECT id,name FROM position",nativeQuery = true)
    List<Position> getAllPosition();
}
