package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.TicketDto;
import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ticket")
public class TicketController {

    // LongLT
    @Autowired
    private ITicketService iTicketService;

    @GetMapping("/edit/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = iTicketService.findTicketById(id);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateTicket(@Valid @RequestBody TicketDto ticketDto, BindingResult bindingResult) {
        new TicketDto().validate(ticketDto, bindingResult);
        Map<String, String> errorList = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                String errorName = ((FieldError) objectError).getField();
                String error = objectError.getDefaultMessage();
                errorList.put(errorName, error);
            }
            return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
        }

        iTicketService.updateTicket(ticketDto.getLocation(), ticketDto.getSumPrice(), ticketDto.getTicketType(), ticketDto.getEndDate(), ticketDto.getId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String inputBirthday = ticketDto.getEndDate();
        LocalDate birthDay = LocalDate.parse(inputBirthday, formatter);
        LocalDate current = LocalDate.now();
        long betweenDate = ChronoUnit.DAYS.between(current, birthDay);
        return new ResponseEntity<>(betweenDate, HttpStatus.OK);
    }
// longLT End}
}