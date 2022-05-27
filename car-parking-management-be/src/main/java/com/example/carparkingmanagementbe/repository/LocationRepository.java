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
    //anh tinh code
    @Transactional
    @Query(value = "SELECT location.id,location.code,location.id_floor as floorId , floor.name as floorName FROM location JOIN floor on  location.id_floor = location.id  where location.code like %?1% and id_floor like %?2%  and location.del_flag = 1",nativeQuery = true)
    List<LocationList> findByList(String code,String id);
//    dat code
@Query(value = "SELECT location.id" +
        ",location.code" +
        ",location.number" +
        ",location.length" +
        ",location.width" +
        ",location.height" +
        ",location.del_flag" +
        ",location.is_empty " +
        ",location.description" +
        ",location.id_floor" +
        " FROM location " +
        "WHERE location.del_flag = 1",
        nativeQuery = true, countQuery = "SELECT COUNT(*) FROM location WHERE location.del_flag = 1")
Page<Location> getAllLocation(Pageable pageable);

    @Query(value = "SELECT " +
            "location.id, " +
            "location.code, " +
            "location.del_flag, " +
            "location.description, " +
            "location.height, " +
            "location.is_empty, " +
            "location.length, " +
            "location.number, " +
            "location.width, " +
            "location.id_floor " +
            "FROM location " +
            "WHERE location.id = ? " +
            "AND location.is_empty = 0 ",
            nativeQuery = true)
    Location findLocationById(Long id);

    @Query(value = "UPDATE location " +
            "SET is_empty = 1 " +
            "WHERE id = ? " +
            "AND location.is_empty = 0 ",
            nativeQuery = true)
    void updateIsEmpty(Long id);
}
