package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.ticket.TicketDtoSearch;

import com.example.carparkingmanagementbe.dto.ticket.UpdateUserEmailDto;
import com.example.carparkingmanagementbe.model.*;

import com.example.carparkingmanagementbe.service.*;

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

    @Autowired
    private ITicketService ticketService;

    @Autowired

    private IFloorsService iFloorsService;

    @Autowired
    private ILocationService iLocationService;

    @Autowired
    private ITicketTypeService iTicketTypeService;

    @Autowired
    private ICarService iCarService;


    @Autowired
    private ITicketTypeService ticketTypeService;

    private Map<String, String> mapError = new HashMap<>();
    private Map<String, String> mapSuccess = new HashMap<>();
    private static final String MESSAGE = "message";
    private static final String EMPLOYEE = "ROLE_EMPLOYEE";
    private static final String ADMIN = "ROLE_ADMIN";
    private static final String NOT_AUTHORIZE = "không đủ thẩm quyền để làm việc";

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
    public ResponseEntity<Object> getSearchTicketPage(@RequestBody TicketDtoSearch ticketDtoSearch, @RequestParam(defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Ticket> ticketPage = ticketService.searchTicketPage(ticketDtoSearch.getFloor(),
                ticketDtoSearch.getTicketTypeName(), ticketDtoSearch.getEndDate(), ticketDtoSearch.getNameCustomer(),
                ticketDtoSearch.getPhoneCustomer(), pageRequest);
        if (ticketPage.isEmpty()) {
            mapError.put(MESSAGE, "không tìm thấy");
            return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);

    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTicket(@RequestBody UpdateUserEmailDto updateUserEmailDto, @PathVariable Long id) {

        Ticket ticket = ticketService.getTicketAction(id, updateUserEmailDto.getEmail());
        if (ticket == null) {
            mapError.put(MESSAGE, "email không phù hợp để xóa vé");
            return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
        } else if (updateUserEmailDto.getRole().contains(EMPLOYEE) || updateUserEmailDto.getRole().contains(ADMIN)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String endDate = ticket.getEndDate();
            LocalDate current = LocalDate.now();
            LocalDate changeEndDay = LocalDate.parse(endDate, formatter);
            Long betweenDay = ChronoUnit.DAYS.between(changeEndDay, current);
            if (betweenDay >= 0 && ticket.getTimeOut() == null) {
                mapError.put(MESSAGE, "xe vẩn còn bên trong nên không thể xóa");
                return new ResponseEntity<>(mapError, HttpStatus.BAD_REQUEST);
            } else if (betweenDay >= 0 && ticket.getTimeOut() != null) {
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
                    mapError.put(MESSAGE, "xe vẫn còn bên trong nên không thể xóa");
                    return new ResponseEntity<>(mapError, HttpStatus.BAD_REQUEST);
                }
            } else {
                mapError.put(MESSAGE, "Vẫn còn hạn");
                return new ResponseEntity<>(mapError, HttpStatus.BAD_REQUEST);
            }
        } else {
            mapError.put(MESSAGE, NOT_AUTHORIZE);
            return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
        }

    }

    @PatchMapping("/updateUserEmail/{id}")
    public ResponseEntity<Object> updateUserEmail(@RequestBody UpdateUserEmailDto updateUserEmailDto, @PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);

        if (ticket == null) {

            mapError.put(MESSAGE, "không tim thấy vé");
            return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
        } else {
            if (updateUserEmailDto.getRole().contains(EMPLOYEE) || updateUserEmailDto.getRole().contains(ADMIN)) {
                if (ticket.getUserEmail() == null) {
                    ticketService.updateUserEmail(updateUserEmailDto.getEmail(), id);

                    mapSuccess.put(MESSAGE, "thành công 1");
                    return new ResponseEntity<>(mapSuccess, HttpStatus.OK);
                } else if (ticket.getUserEmail().equals(updateUserEmailDto.getEmail())) {


                    mapSuccess.put(MESSAGE, "thành công 2");
                    return new ResponseEntity<>(mapSuccess, HttpStatus.OK);

                } else {
                    mapError.put(MESSAGE, "đã có người đang thao tác với vé");
                    return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
                }

            } else {

                mapError.put(MESSAGE, NOT_AUTHORIZE);
                return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
            }

        }


    }

    @PostMapping("/getTicketAction/{id}")
    public ResponseEntity<Object> getTicketAction(@RequestBody UpdateUserEmailDto updateUserEmailDto, @PathVariable Long id) {
        if (updateUserEmailDto.getRole().contains(EMPLOYEE) || updateUserEmailDto.getRole().contains(ADMIN)) {
            Ticket ticket = ticketService.getTicketAction(id, updateUserEmailDto.getEmail());
            if (ticket == null) {

                mapError.put(MESSAGE, "vé đang được người khác thao tác không thể truy cập");
                return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } else {

            mapError.put(MESSAGE, NOT_AUTHORIZE);
            return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
        }


    }

    @PatchMapping("/updateUserNull/{id}")
    public ResponseEntity<Object> updateUserNull(@RequestBody UpdateUserEmailDto updateUserEmailDto, @PathVariable Long id) {
        if (updateUserEmailDto.getRole().contains(EMPLOYEE) || updateUserEmailDto.getRole().contains(ADMIN)) {
            Ticket ticket = ticketService.getTicketAction(id, updateUserEmailDto.getEmail());
            if (ticket == null) {

                mapError.put(MESSAGE, "vé đang được người khác thao tác không thể truy cập");
                return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
            } else {
                ticketService.updateNullUser(id);

                mapSuccess.put(MESSAGE, "da update ve null");
                return new ResponseEntity<>(mapSuccess, HttpStatus.OK);
            }

        } else {

            mapError.put(MESSAGE, NOT_AUTHORIZE);
            return new ResponseEntity<>(mapError, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/ticketType")
    public ResponseEntity<List<TicketType>> getAllTicketType() {
        List<TicketType> ticketTypeList = iTicketTypeService.findAllTicket();
        if (ticketTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketTypeList, HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> locationList = iLocationService.findAll();
        if (locationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @GetMapping("/floor")
    public ResponseEntity<List<Floor>> getAllFloor() {
        List<Floor> floors = iFloorsService.findAllFloor();
        if (floors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAllCar() {
        List<Car> cars = iCarService.findAll();
        if (cars.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.findTicketById(id);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Object> updateTicket(@Valid @RequestBody TicketDto ticketDto, BindingResult bindingResult) {
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

                mapError.put(MESSAGE, "không tìm thấy ticket");
                return new ResponseEntity<>(mapError, HttpStatus.BAD_REQUEST);
            } else {
                ticketService.updateTicket(ticketDto.getLocation(), ticketDto.getSumPrice(), ticketDto.getTicketType(), ticketDto.getEndDate(), ticketDto.getId());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String inputBirthday = ticketDto.getEndDate();
                LocalDate birthDay = LocalDate.parse(inputBirthday, formatter);
                LocalDate current = LocalDate.now();
                long betweenDate = ChronoUnit.DAYS.between(current, birthDay);

                mapSuccess.put("time", "thời gian chenh lệch: " + betweenDate);
                return new ResponseEntity<>(mapSuccess, HttpStatus.OK);
            }


        }
    }


    @GetMapping("/getByFloor/{id}")
    public ResponseEntity<List<Location>> getAllLocationByFloor(@PathVariable Long id) {
        List<Location> locationList = iLocationService.getListLocation(id);
        if (locationList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }


}

