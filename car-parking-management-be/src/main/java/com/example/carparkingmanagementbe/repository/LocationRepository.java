package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
    @Transactional
    @Query(value = "SELECT location.id,location.code,location.id_floor as floorId , floor.name as floorName FROM location JOIN floor on  location.id_floor = location.id  where location.code like %?1% and id_floor like %?2%  and location.del_flag = 1",nativeQuery = true)
    List<LocationList> findByList(String code,String id);
}
