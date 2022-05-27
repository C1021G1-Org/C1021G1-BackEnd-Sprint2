package com.example.carparkingmanagementbe.repository;


import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

//location.description,\n" +
//        "   location.width, location.is_empty, location.number,\n" +
//        "   location.height, location.length, location.del_flag,\n" +
//        "   location.id_floor,
@Transactional
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {


    //TinhHD code
    @Transactional
    @Query(value = "SELECT location.id,location.code,location.id_floor as floorId , floor.name as floorName FROM location JOIN floor on  location.id_floor = location.id  where location.code like %?1% and id_floor like %?2%  and location.del_flag = 1", nativeQuery = true)
    List<LocationList> findByList(String code, String id);


    //detail location TrongTA
    @Query(value = "SELECT location.id, location.code, floor.name as nameFloor, customer.name as nameCustomer,\n" +
            "   customer.phone, customer.birthday, customer.email,\n" +
            "   car_type.name as nameTypeCar, car.car_company as carCompany,car.name as nameCar, car.car_plate as carPlate\n" +
            "FROM location\n" +
            "JOIN floor on floor.id = location.id_floor\n" +
            "JOIN ticket on ticket.id_location = location.id\n" +
            "JOIN car on ticket.id_car = car.id\n" +
            "JOIN car_type on car_type.id = car.id_car_type\n" +
            "JOIN customer on customer.id = car.id_customer\n" +
            "WHERE location.id = ?", nativeQuery = true)
    LocationDetailDto findLocationsById(Long id);

    //tìm findById location của trongTA
    @Query(value = "SELECT  location.id, location.`code`, location.`description`,\n" +
            "\t\tlocation.width, location.is_empty, location.number,\n" +
            "\t\tlocation.height, location.length, location.del_flag,\n" +
            "\t\tfloor.name, customer.name, location.id_floor,\n" +
            "\t\tcustomer.phone, customer.birthday, customer.email,\n" +
            "\t\tcar_type.name, car.car_company, car.name, car.car_plate\n" +
            "FROM location\n" +
            "\tJOIN floor on floor.id = location.id_floor\n" +
            "\tJOIN ticket on ticket.id_location = location.id\n" +
            "\tJOIN car on ticket.id_car = car.id\n" +
            "\tJOIN car_type on car_type.id = car.id_car_type\n" +
            "\tJOIN customer on customer.id = car.id_customer\n" +
            "WHERE location.id = ?", nativeQuery = true)
    Location findLocationById(Long id);

    //Xóa vị trí đỗ TrongTA
    @Modifying
    @Query(value = "UPDATE location" +
            " SET location.del_flag = 0  and location.is_empty = 0 " +
            "where location.id = ?", nativeQuery = true)
    void removeLocationById(Long id);

    //datNVN code list

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


    //datNVN code tim id
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
    Location findByIdLocation(Long id);

    //datNVN code update
    @Query(value = "UPDATE location " +
            "SET is_empty = 1 " +
            "WHERE id = ? " +
            "AND location.is_empty = 0 ",
            nativeQuery = true)
    void updateIsEmpty(Long id);
}



