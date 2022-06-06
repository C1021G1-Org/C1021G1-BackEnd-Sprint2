package com.example.carparkingmanagementbe.service;
import com.example.carparkingmanagementbe.dto.EmptyLocation;
import com.example.carparkingmanagementbe.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ITicketService {
        //hieu begin

        List<Ticket> listTicket();

        EmptyLocation emptyLocation();

        void createTicket(Ticket ticket);

        void updateTicket(Ticket ticket);

        void checking(Boolean isChecking);
        //hieu end

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


        //    LongLT
        Ticket findTicketById(Long id);

        void updateTicket(Long idLocation,
                          Double sumPrice,
                          Long idTicketType,

                          String endDate,
                          Long idTicket);

    void save(Ticket ticket1);
//    LongLT End

    }
