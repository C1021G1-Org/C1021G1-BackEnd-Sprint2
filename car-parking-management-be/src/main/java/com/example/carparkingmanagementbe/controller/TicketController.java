package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CreateTicketDto;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.model.TicketType;
import com.example.carparkingmanagementbe.service.Impl.TicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;



    @PostMapping("/create")
    public ResponseEntity<?> createTicket (@Valid @RequestBody CreateTicketDto createTicketDto){
        Car car = new Car();
        car.setId(createTicketDto.getCar());
        Location location = new Location();
        location.setId(createTicketDto.getLocation());
        TicketType ticketType = new TicketType();
        ticketType.setId(createTicketDto.getTicketType());
        Ticket ticket = new Ticket();
        createTicketDto.setChecking(false);
        createTicketDto.setDelFlag(true);
        ticket.setCar(car);
        ticket.setLocation(location);
        ticket.setTicketType(ticketType);
        BeanUtils.copyProperties(createTicketDto,ticket);
        ticket.setIsDoing(false);
        ticketService.createTicket(ticket);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PatchMapping("/updateTime")
    public ResponseEntity<?> update (@Valid @RequestBody CreateTicketDto createTicketDto){
        Car car = new Car();
        car.setId(createTicketDto.getCar());
        Location location = new Location();
        location.setId(createTicketDto.getLocation());
        TicketType ticketType = new TicketType();
        ticketType.setId(createTicketDto.getTicketType());
        Ticket ticket = new Ticket();
        createTicketDto.setChecking(false);
        createTicketDto.setDelFlag(true);
        ticket.setCar(car);
        ticket.setLocation(location);
        ticket.setTicketType(ticketType);
        BeanUtils.copyProperties(createTicketDto,ticket);
        ticket.setIsDoing(false);
        ticketService.updateTicket(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PatchMapping("/isChecking")
//    public ResponseEntity<?> isChecking (Boolean isChecking){
//        ticketService.checking(isChecking);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }


}
