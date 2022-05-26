package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.ticket.TicketDtoSearch;
import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.repository.TicketRepository;
import com.example.carparkingmanagementbe.repository.TicketTypeRepository;
import com.example.carparkingmanagementbe.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TicketController {
    //ta controller begin
    @Autowired
    private ITicketService ticketService;


    @GetMapping("/check")
    public ResponseEntity<Page<Ticket>> getAllTicket(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Ticket> ticketPage = ticketService.findAll(pageable);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Ticket>> getSearchTicketPage(@RequestBody TicketDtoSearch ticketDtoSearch, @RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Ticket> ticketPage = ticketService.searchTicketPage(ticketDtoSearch.getFloor(),
                ticketDtoSearch.getTicketTypeName(), ticketDtoSearch.getEndDate(), ticketDtoSearch.getNameCustomer(),
                ticketDtoSearch.getPhoneCustomer(), pageRequest);
        if (ticketPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);

    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id) {

        Ticket ticket = ticketService.getTicketById(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String endDate = ticket.getEndDate();
        LocalDate current = LocalDate.now();
        LocalDate changeEndDay = LocalDate.parse(endDate, formatter);
        Long betweenDay = ChronoUnit.DAYS.between(changeEndDay,current);
        if (betweenDay >= 0) {
            if (ticket.getTimeOut() == null) {
                Map<String, String> map = new HashMap<>();
                map.put("messageEros", "xe vẩn còn bên trong nên không thể xóa");
                return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
            } else {
                DateTimeFormatter formatterInOut = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                String timeIn = ticket.getTimeIn();
                String timeOut = ticket.getTimeOut();
                String changeTimeIn = String.format(timeIn, formatterInOut);
                String changeTimeOut = String.format(timeOut, formatterInOut);
                int check = changeTimeIn.compareTo(changeTimeOut);
                if (check < 0) {
                    ticketService.deleteTicketByDel(ticket.getId());
                    return new ResponseEntity<>(check, HttpStatus.OK);
                } else {
                    Map<String, String> map = new HashMap<>();
                    map.put("messageEros", "xe vẩn còn bên trong nên không thể xóa");
                    return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
                }
            }
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("messageEros", "Vẩn còn hạng");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }

// tam controller end
}
