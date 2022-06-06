package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.dto.CarPlateDto;
import com.example.carparkingmanagementbe.dto.CarTicketDto;
import com.example.carparkingmanagementbe.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carparkingmanagementbe.model.Car;
import org.springframework.data.jpa.repository.Modifying;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    //TrongHD thêm mới xe
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Car(code,name,car_plate,car_company,id_car_type,del_flag)" +
            " VALUES(?1,?2,?3,?4,?5,?6) ", nativeQuery = true)
    void createCarCustomerNull(String code, String name, String carPlate, String carCompany,
                      Long idCarType, Boolean delFlag);

    //TrongHD thêm mới xe
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Car(code,name,car_plate,car_company,id_customer,id_car_type,del_flag)" +
            " VALUES(?1,?2,?3,?4,?5,?6, ?7) ", nativeQuery = true)
    void createCar(String code, String name, String carPlate, String carCompany,
                   Long idCustomer, Long idCarType, Boolean delFlag);

    //    tronghd lấy giá trị validate trùng nhau
    @Query(value = "select count(code) from car where code = ?", nativeQuery = true)
    Integer finByCodeCar(String code);

    //    tronghd lấy giá trị validate trùng nhau
    @Query(value = "select count(car_plate) from car where car_plate = ?", nativeQuery = true)
    Integer finByCarPlate(String carPlate);

    //BaoND lấy thông tin xe
    @Query(value = "select car.id," +
            "car.car_company," +
            "car.car_plate," +
            "car.`code`," +
            "car.`name`," +
            "car.id_car_type," +
            "car.id_customer," +
            "car.id_employee," +
            "customer.address," +
            "customer.account_id," +
            "customer.birthday," +
            "customer.`code`," +
            "customer.email," +
            "customer.gender," +
            "customer.id_card," +
            "customer.`name`," +
            "customer.phone," +
            "customer.del_flag," +
            "customer.id_ward " +
            "from car " +
            "join customer " +
            "on car.id_customer = customer.id " +
            "where customer.id = ? and car.del_flag = 1;",nativeQuery = true)
    List<Car> selectCustomerAndCar(Long id);

    //TrongHD lấy thông tin khách hàng
    @Query(value = "select car.id," +
            "car.car_company," +
            "car.car_plate," +
            "car.`code`," +
            "car.`name`," +
            "car.id_car_type," +
            "car.id_customer," +
            "car.id_employee," +
            "customer.address," +
            "customer.account_id," +
            "customer.birthday," +
            "customer.email," +
            "customer.gender," +
            "customer.id_card," +
            "customer.`name`," +
            "customer.phone," +
            "customer.del_flag," +
            "customer.id_ward " +
            "from car " +
            "join customer " +
            "on car.id_customer = customer.id " +
            "where customer.id = ?;",nativeQuery = true)
    List<Car> findByIdCustomer(Long id);

    @Query(value = "SELECT id,car_company,car_plate,`code`,del_flag,`name`,id_car_type,id_customer,id_employee FROM car where id_customer is null and del_flag = 1;",nativeQuery = true)
    List<Car> findCarByIdCustomerNull();

    @Transactional
    @Modifying
    @Query(value = "UPDATE car AS c SET c.id_customer = ? WHERE c.id_customer IS null;",nativeQuery = true)
    void updateCarByIdCustomerNull(Long idCustomer);

    @Modifying
    @Query(value = "update car set del_flag = 0 where id = ? ;", nativeQuery = true)
    void deleteCarById(Long id);

    @Query(value = "SELECT id,car_company,car_plate,`code`,del_flag,`name`,id_car_type,id_customer,id_employee " +
            "FROM car " +
            "where id = ? " +
            "and del_flag = 1;",nativeQuery = true)
    Car findCarById(Long id);

    @Query(value = "select car.id," +
            "car.car_company," +
            "car.car_plate," +
            "car.`code`," +
            "car.`name`," +
            "car.id_car_type," +
            "car.id_customer," +
            "car.id_employee," +
            "customer.address," +
            "customer.account_id," +
            "customer.birthday," +
            "customer.email," +
            "customer.gender," +
            "customer.id_card," +
            "customer.`name`," +
            "customer.phone," +
            "customer.del_flag," +
            "customer.id_ward " +
            "from car " +
            "join customer " +
            "on car.id_customer = customer.id " +
            "where customer.email = ?;",nativeQuery = true)
    List<Car> getListCarByEmail(String email);

    // SonDCM tim xe modal
    @Query(value = "SELECT c.car_plate carPlate,cs.name customerName,cs.id_card idCard " +
            "FROM car AS c " +
            "   JOIN customer AS cs " +
            "       ON c.id_customer = cs.id " +
            "WHERE cs.name like %:name% OR  cs.phone like %:phone% OR c.car_plate like %:plate%", nativeQuery = true)
    List<CarPlateDto> findCarModal(@Param("name") String name, @Param("phone") String phone, @Param("plate") String plate);
   // SonDCM chon xe
    @Query(value = "select c.car_plate carPlate," +
            "c.name carName," +
            "cs.name customerName," +
            "t.id_ticket_type idTicketType," +
            "c.car_company carCompany," +
            "cs.phone customerPhone," +
            "c.start_date startDate," +
            "c.end_date endDate," +
            "l.id_floor idFloor," +
            "l.code code," +
            "t.img_car_in imgCarIn," +
            "t.img_car_out imgCarOut" +
            " from car as c" +
            " join ticket as t on c.id = t.id_car " +
            " join location as l on t.id_location = l.id " +
            " join customer as cs on cs.id = c.id_customer " +
            " where car_plate = ?1", nativeQuery = true)
    List<CarTicketDto> chooseCar( String plate);

}
