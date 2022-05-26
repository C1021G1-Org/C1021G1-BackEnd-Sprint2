package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ITicketService {


    // tam begin
    Page<Ticket> findAll(Pageable pageable);
    Page<Ticket> searchTicketPage(String floor,
                                  String ticketTypeName,
                                  String endDate,
                                  String nameCustomer,
                                  String phoneCustomer,
                                  Pageable pageable);
    void deleteTicketByDel(Long idTicket);

    Ticket getTicketById(Long idTicket);

    // tam end
}
