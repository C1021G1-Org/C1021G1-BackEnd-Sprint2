package com.example.carparkingmanagementbe.repository;

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

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {


    // tam query begin
    @Query(value = "select ticket.id,ticket.code,ticket.del_flag,ticket.img_car_in,ticket.img_car_out,ticket.is_doing, " +
            "            ticket.sum_price,ticket.time_in,ticket.time_out,ticket.id_car,ticket.id_location,ticket.id_ticket_type " +
            "            from ticket " +
            "            where ticket.del_flag = 1 " +
            "            order by ticket.id desc", nativeQuery = true,
            countQuery = "select count(*) from ticket where ticket.id = 1")
    Page<Ticket> getAllTicketPage(Pageable pageable);


    @Query(value = "select ticket.id,ticket.code,ticket.del_flag,ticket.img_car_in,ticket.img_car_out,ticket.is_doing" +
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
            "and car.end_date like %:endDate% " +
            "and customer.name like %:nameCustomer% " +
            "and customer.phone like %:phoneCustomer% ", nativeQuery = true
            , countQuery = "select count(*) from (select ticket.id,ticket.code,ticket.del_flag,ticket.img_car_in,ticket.img_car_out,ticket.is_doing, " +
            "                                ticket.sum_price,ticket.time_in,ticket.time_out,ticket.id_car,ticket.id_location,ticket.id_ticket_type  " +
            "                       from ticket  " +
            "                      join ticket_type on ticket.id_ticket_type = ticket_type.id  " +
            "                       join location on ticket.id_location = location.id  " +
            "                      join floor on location.id_floor = floor.id " +
            "                     join car on ticket.id_car = car.id  " +
            "                     join customer on customer.id = car.id_customer " +
            "                    where  ticket.del_flag = 1  " +
            "                    and floor.name like %:floor% " +
            "                   and ticket_type.name like %:ticketTypeName% " +
            "                      and car.end_date like %:endDate% " +
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
    @Query(value = "update ticket set ticket.del_flag = 0 from ticket " +
            "where ticket.id = :idTicket ", nativeQuery = true)
    void deleteTicketByDel(@Param("idTicket") Long idTicket);
    @Query(value = "select ticket.id,ticket.code,ticket.del_flag,ticket.img_car_in,ticket.img_car_out,ticket.is_doing, " +
            "ticket.sum_price,ticket.time_in,ticket.time_out,ticket.id_car,ticket.id_location,ticket.id_ticket_type " +
            "from ticket " +
            "where ticket.id = :idTicket " +
            "and ticket.del_flag = 1 ",nativeQuery = true)
    Ticket getTicketById(@Param("idTicket")Long idTicket);
    // tam end
}
