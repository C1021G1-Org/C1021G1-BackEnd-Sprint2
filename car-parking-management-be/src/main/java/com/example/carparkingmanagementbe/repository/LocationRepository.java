package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "select location.id,location.code,location.number,location.length,location.width,location.height,location.del_flag,location.is_empty,location.description, " +
            "location.id_floor " +
            "from location " +
            "join floor on floor.id = location.id_floor " +
            "where location.id_floor = :idFloor ", nativeQuery = true)
    List<Location> getListLocation(@Param("idFloor") Long idFloor);

}
