package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.ticket.TicketDtoSearch;
import com.example.carparkingmanagementbe.model.Floor;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.model.Ticket;

import com.example.carparkingmanagementbe.model.TicketType;
import com.example.carparkingmanagementbe.service.IFloorsService;
import com.example.carparkingmanagementbe.service.ILocationService;
import com.example.carparkingmanagementbe.service.ITicketService;
import com.example.carparkingmanagementbe.service.ITicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


import com.example.carparkingmanagementbe.dto.TicketDto;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;


import javax.validation.Valid;


import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ticket")
public class TicketController {
    //ta controller begin
    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IFloorsService floorsService;

    @Autowired
    private ITicketTypeService ticketTypeService;

    @Autowired
    private ILocationService locationService;

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
    public ResponseEntity<?> getSearchTicketPage(@RequestBody TicketDtoSearch ticketDtoSearch, @RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Ticket> ticketPage = ticketService.searchTicketPage(ticketDtoSearch.getFloor(),
                ticketDtoSearch.getTicketTypeName(), ticketDtoSearch.getEndDate(), ticketDtoSearch.getNameCustomer(),
                ticketDtoSearch.getPhoneCustomer(), pageRequest);
        if (ticketPage.isEmpty()) {
            Map<String, String> map = new HashMap<>();
            map.put("messageEros", "hien tai trong da ta chua co");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);

    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id) {

        Ticket ticket = ticketService.getTicketById(id);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String endDate = ticket.getEndDate();
        LocalDate current = LocalDate.now();
        LocalDate changeEndDay = LocalDate.parse(endDate, formatter);
        Long betweenDay = ChronoUnit.DAYS.between(changeEndDay, current);
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

    @GetMapping("/getFloor")
    public ResponseEntity<List<Floor>> getAllFloor() {
        List<Floor> floorList = floorsService.getAllFloor();
        if (floorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(floorList, HttpStatus.OK);
    }

    @GetMapping("/getTypeTicket")
    public ResponseEntity<List<TicketType>> getAllTypeTicket() {
        List<TicketType> ticketTypeList = ticketTypeService.getAllTicketType();
        if (ticketTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketTypeList, HttpStatus.OK);
    }

// tam controller end
//long begin

    @GetMapping("/edit/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.findTicketById(id);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PatchMapping("/update")
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
        } else {
            Ticket ticket = ticketService.findTicketById(ticketDto.getId());
            if (ticket == null) {
                Map<String, String> map = new HashMap<>();
                map.put("messageEros", "không tìm thấy ticket");
                return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
            } else {
                ticketService.updateTicket(ticketDto.getLocation(), ticketDto.getSumPrice(), ticketDto.getTicketType(), ticketDto.getEndDate(), ticketDto.getId());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String inputBirthday = ticketDto.getEndDate();
                LocalDate birthDay = LocalDate.parse(inputBirthday, formatter);
                LocalDate current = LocalDate.now();
                long betweenDate = ChronoUnit.DAYS.between(current, birthDay);
                Map<String, String> map = new HashMap<>();
                map.put("time", "thời gian chenh lệch: " + betweenDate);
                return new ResponseEntity<>(map, HttpStatus.OK);
            }


        }
    }

    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> locationList = locationService.findAll();
        if (locationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }
    @GetMapping("/getByFloor/{id}")
    public ResponseEntity<List<Location>> getAllLocationByFloor(@PathVariable Long id) {
        List<Location> locationList = locationService.getListLocation(id);
        if (locationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }


// longLT End}
}

