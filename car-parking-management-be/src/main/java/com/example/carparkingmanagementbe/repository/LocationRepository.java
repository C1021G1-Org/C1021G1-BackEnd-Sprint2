package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Long, Location> {

}
