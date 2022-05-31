package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.TicketType;
import com.example.carparkingmanagementbe.repository.TicketTypeRepository;
import com.example.carparkingmanagementbe.service.ITicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;

import java.util.List;

@Service
public class TicketTypeService implements ITicketTypeService {
    @Autowired
    private TicketTypeRepository ticketTypeRepository;
    @Override
    public List<TicketType> findAllTicket() {
        return ticketTypeRepository.findAll();
    }
}
