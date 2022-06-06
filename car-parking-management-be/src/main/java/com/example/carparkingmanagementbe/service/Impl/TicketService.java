package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.EmptyLocation;
import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.repository.TicketRepository;
import com.example.carparkingmanagementbe.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void checking(Boolean isChecking) {
        ticketRepository.checking(isChecking);
    }

    @Override
    public List<Ticket> listTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public EmptyLocation emptyLocation() {
        return ticketRepository.emptyLocation();
    }

    @Override
    public void createTicket(Ticket ticket) {
//        ticketRepository.createTicket(ticket.getCode(),ticket.getDelFlag(),ticket.getEndDate(),
//                ticket.getImgCarIn(),ticket.getImgCarOut(),ticket.getIsDoing(),ticket.getStartDate() ,ticket.getSumPrice(),
//                ticket.getTimeIn(),ticket.getTimeOut(),ticket.getCar(),ticket.getLocation(),
//                ticket.getTicketType());
        ticketRepository.save(ticket);
    }

    // tam begin



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



    //    LongLT


    @Override
    public Ticket findTicketById(Long id) {

        return ticketRepository.findByIdTicket(id);
    }
    @Override
    public void updateTicket(Long idLocation, Double sumPrice, Long idTicketType, String endDate, Long idTicket) {
        ticketRepository.updateTicket(idLocation, sumPrice, idTicketType, endDate, idTicket);
    }

    @Override
    public void save(Ticket ticket1) {
        ticketRepository.save(ticket1);
    }
//    LongLT
}
