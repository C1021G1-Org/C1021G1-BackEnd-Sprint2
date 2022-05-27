package com.example.carparkingmanagementbe.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TicketDto implements Validator {
    private Long id;


    private Double sumPrice;

    @NotNull(message = "Vui lòng không để trống")
    private Long ticketType;

    @NotNull(message = "Vui lòng không để trống")
    private Long location;

    @NotBlank(message = "Vui lòng không để trống")
    private String endDate;

    public TicketDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Long getTicketType() {
        return ticketType;
    }

    public void setTicketType(Long ticketType) {
        this.ticketType = ticketType;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TicketDto productDto = (TicketDto) target;
        String inputBirthday = productDto.getEndDate();
        LocalDate birthDay = LocalDate.parse(inputBirthday, formatter);
        //  LocalDate birthdayToLocalDate = LocalDate.of(birthDay.getYear(),birthDay.getMonth(), birthDay.getDayOfMonth());
        LocalDate current = LocalDate.now();
        long betweenDate = ChronoUnit.DAYS.between( current,birthDay);

        if (betweenDate <0 || betweenDate > 31) {
            errors.rejectValue("endDate", "", "error date update");
        }


    }

}

