package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.dto.EmptyLocation;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.model.TicketType;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.carparkingmanagementbe.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.carparkingmanagementbe.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    //Hieu


    @Query(value = "SELECT location.id as idLocation, location.code as nameLocation, floor.name as nameFloor \n" +
            "FROM location JOIN floor ON location.id_floor = floor.id where location.is_empty\n" +
            "LIMIT 1", nativeQuery = true)
    EmptyLocation emptyLocation();


    @Query(value = "SELECT * " +
            "FROM ticket ", nativeQuery = true)
    List<Ticket> findAllTicket();



    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Ticket(code, " +
            "del_flag, " +
            "end_date, " +
            "img_car_in, " +
            "img_car_out, " +
            "is_doing, " +
            "start_date, " +
            "sum_price, " +
            "time_in, " +
            "time_out, " +
            "id_car, " +
            "id_location, " +
            "id_ticket_type, ) " +
            " VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13) ", nativeQuery = true)
    void createTicket(String code, Boolean delFlag, String startDate, String imgCarIn,
                      String imgCarOut, Boolean isDoing, String endDate, Double sumPrice, String timeIn,
                      String timeOut, Car car, Location location, TicketType ticketType);


    @Modifying
    @Query(value = "update ticket " +
            "join car on car.id = ticket.id_car " +
            "set ticket.time_in = ?1 " +
            "set ticket.time_out = ?2 " +
            "where car.car_plate = ticket.id_car", nativeQuery = true)
    void updateTicket(String timeIn, String timeOut);


    // tam query begin
    @Query(value = "select ticket.id,ticket.code,ticket.del_flag,ticket.end_date,ticket.img_car_in,ticket.img_car_out,ticket.is_doing,ticket.start_date " +
            "            ,ticket.sum_price,ticket.time_in,ticket.time_out,ticket.id_car,ticket.id_location,ticket.id_ticket_type " +
            "            from ticket " +
            "            where ticket.del_flag = 1 " +
            "            order by ticket.id desc", nativeQuery = true,
            countQuery = "select count(*) from ticket where ticket.id = 1")
    Page<Ticket> getAllTicketPage(Pageable pageable);


    @Query(value = "select ticket.id,ticket.code,ticket.del_flag,ticket.end_date,ticket.img_car_in,ticket.img_car_out,ticket.is_doing,ticket.start_date " +
            ",ticket.sum_price,ticket.time_in,ticket.time_out,ticket.id_car,ticket.id_location,ticket.id_ticket_type " +
            "from ticket " +
            "join ticket_type on ticket.id_ticket_type = ticket_type.id " +
            "join location on ticket.id_location = location.id " +
            "join floor on location.id_floor = floor.id " +
            "join car on ticket.id_car = car.id " +
            "join customer on customer.id = car.id_customer " +
            "where ticket.del_flag = 1 " +
            "and floor.name like %:floor% " +
            "and ticket_type.name like %:ticketTypeName% " +
            "and ticket.end_date like %:endDate% " +
            "and customer.name like %:nameCustomer% " +
            "and customer.phone like %:phoneCustomer% ", nativeQuery = true
            , countQuery = "select count(*) from (select ticket.id,ticket.code,ticket.del_flag,ticket.end_date,ticket.img_car_in,ticket.img_car_out,ticket.is_doing,ticket.start_date " +
            "                                ,ticket.sum_price,ticket.time_in,ticket.time_out,ticket.id_car,ticket.id_location,ticket.id_ticket_type  " +
            "                       from ticket  " +
            "                      join ticket_type on ticket.id_ticket_type = ticket_type.id  " +
            "                       join location on ticket.id_location = location.id  " +
            "                      join floor on location.id_floor = floor.id " +
            "                     join car on ticket.id_car = car.id  " +
            "                     join customer on customer.id = car.id_customer " +
            "                    where  ticket.del_flag = 1  " +
            "                    and floor.name like %:floor% " +
            "                   and ticket_type.name like %:ticketTypeName% " +
            "                      and ticket.end_date like %:endDate% " +
            "                     and customer.name like %:nameCustomer% " +
            "                      and customer.phone like %:phoneCustomer% ) as saeuawqik"
    )
    Page<Ticket> searchTicketPage(@Param("floor") String floor,
                                  @Param("ticketTypeName") String ticketTypeName,
                                  @Param("endDate") String endDate,
                                  @Param("nameCustomer") String nameCustomer,
                                  @Param("phoneCustomer") String phoneCustomer,
                                  Pageable pageable);

    @Modifying
    @Query(value = "update ticket " +
            "join location on ticket.id_location = location.id " +
            "set ticket.del_flag = 0 " +
            ",location.is_empty = 0 " +
            "where ticket.id = :idTicket ", nativeQuery = true)
    void deleteTicketByDel(@Param("idTicket") Long idTicket);


    @Query(value = "select ticket.id,ticket.code,ticket.del_flag,ticket.end_date,ticket.img_car_in,ticket.img_car_out,ticket.is_doing,ticket.start_date " +
            ",ticket.sum_price,ticket.time_in,ticket.time_out,ticket.id_car,ticket.id_location,ticket.id_ticket_type " +
            "from ticket " +
            "where ticket.id = :idTicket " +
            "and ticket.del_flag = 1 ", nativeQuery = true)
    Ticket getTicketById(@Param("idTicket") Long idTicket);
    // tam end


//    LongLT

    @Query(value = "select ticket.id, ticket.code, ticket.start_date,ticket.end_date, ticket.img_car_in, ticket.img_car_out,\n" +
            "            ticket.sum_price, ticket.time_in, ticket.time_out, ticket.is_doing, ticket.id_car, ticket.id_location, ticket.id_ticket_type, ticket.del_flag\n" +
            "            from ticket where ticket.id = ? " +
            "and ticket.del_flag = 1 ", nativeQuery = true)
    Ticket findByIdTicket(Long id);

    @Modifying
    @Query(value = "update ticket " +
            "join location on ticket.id_location = location.id " +
            "join ticket_type on ticket_type.id = ticket.id_ticket_type " +
            "join car on ticket.id_car = car.id " +
            "set ticket.id_location = :idLocation, " +
            "ticket.sum_price = :sumPrice, " +
            "ticket.id_ticket_type = :idTicketType, " +
            "ticket.end_date = :endDate " +
            "where ticket.id = :idTicket " +
            "and ticket.del_flag = 1 ",nativeQuery = true)
    void updateTicket(@Param("idLocation")Long idLocation,
                      @Param("sumPrice")Double sumPrice,
                      @Param("idTicketType")Long idTicketType,
                      @Param("endDate")String endDate,
                      @Param("idTicket")Long idTicket );


    //    LongLT
    @Modifying
    @Query(value = "update ticket " +
            "set ticket.is_doing = ?1 " +
            "where car.car_plate = ticket.id_car", nativeQuery = true)
    void checking(Boolean isChecking);
}
