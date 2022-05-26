package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.repository.TicketRepository;
import com.example.carparkingmanagementbe.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TicketServiceImpl implements ITicketService {


    // tam begin
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return ticketRepository.getAllTicketPage(pageable);
    }

    @Override
    public Page<Ticket> searchTicketPage(String floor, String ticketTypeName, String endDate, String nameCustomer, String phoneCustomer, Pageable pageable) {
        return ticketRepository.searchTicketPage(floor, ticketTypeName, endDate, nameCustomer, phoneCustomer, pageable);
    }

    @Override
    public void deleteTicketByDel(Long idTicket) {
        ticketRepository.deleteTicketByDel(idTicket);
    }

    @Override
    public Ticket getTicketById(Long idTicket) {
        return ticketRepository.getTicketById(idTicket);
    }


    // tam end
}
