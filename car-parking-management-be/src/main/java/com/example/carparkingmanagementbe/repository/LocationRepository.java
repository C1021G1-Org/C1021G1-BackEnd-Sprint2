package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.model.AllowedCarParking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;



@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {


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


    //Xóa vị trí đỗ TrongTA
    @Modifying
    @Query(value = "UPDATE location" +
            " SET location.del_flag = 0  and location.is_empty = 0 " +
            "where location.id = ?", nativeQuery = true)
    void removeLocationById(Long id);


    /*Find By Id Dùng Chung*/
    @Query(value = "SELECT location.id, location.code, location.del_flag, location.description, location.height, " +
            "location.is_empty, location.length, location.number, location.width, location.id_floor " +
            "FROM location WHERE location.id = ? " +
            "AND del_flag = 1 ", nativeQuery = true)
    Location findLocationById(Long id);

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
    /*TuanPDCoding*/
    @Modifying
    @Query(value = "UPDATE location SET\n" +
            "       location.height = ?," +
            "       location.length = ?,\n" +
            "       location.width = ?\n" +
            "       WHERE location.id  = ?", nativeQuery = true)
    void editLocationById(Double height, Double length, Double width, Long id);

    /*TuanPDCoding*/
    @Modifying
    @Query(value = "INSERT INTO location" +
            "(location.code, location.number, location.del_flag, location.is_empty, location.height, location.length," +
            " location.width, location.description, location.id_floor) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
    void createLocation(String code, Long number, Boolean del_flag, Boolean is_empty,
                        Double height, Double length, Double width, String description, Long id_floor);

    /*TuanPDCoding*/
    @Modifying
    @Query(value = "UPDATE location_allowed_car_parking SET \n" +
            " location.id = ?" +
            " allow_car_parking_id\n" +
            "WHERE location.id = ?", nativeQuery = true)
    void editAllowParkingById(Long id, Set<AllowedCarParking> allowCarParking);


    /*TuanPDCoding*/
    @Modifying
    @Query(value = "INSERT INTO location_allowed_car_parking \n" +
            "(location_id, allowed_car_parking_id) \n" +
            "VALUES (LAST_INSERT_ID(), ?1)", nativeQuery = true)
    void createAllowParking(Long id_floor, Set<AllowedCarParking> allowCarParking);



    /*TinhHDCoding*/
    @Transactional
    @Query(value = "SELECT location.id,location.code,location.id_floor as floorId , floor.name as floorName " +
            "FROM location JOIN floor on  location.id_floor = floor.id  " +
            "where location.code like %?1% and id_floor like %?2%  " +
            "and location.del_flag = 1", nativeQuery = true)
    List<LocationList> findByList(String code, String id);


    /*DatNVNCoding*/
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
            "WHERE  location.del_flag = 1",
            nativeQuery = true, countQuery = "SELECT COUNT(*) FROM location WHERE location.del_flag = 1")
    Page<Location> getAllLocation(Pageable pageable);




    //datNVN code update
    @Modifying
    @Query(value = "UPDATE location " +
            "SET is_empty = 1 " +
            "WHERE id = ? ",
            nativeQuery = true)
    void updateIsEmpty(Long id);

    @Transactional
    @Query(value = "SELECT * " +
            "FROM location " +
            "WHERE location.code " +
            "LIKE :code " +
            "AND location.del_flag = 1",
            nativeQuery = true,
            countQuery = "SELECT COUNT(*) FROM location WHERE location.del_flag = 1")
    Page<Location> searchLocationCode(@Param("code")String code, Pageable pageable);
}



