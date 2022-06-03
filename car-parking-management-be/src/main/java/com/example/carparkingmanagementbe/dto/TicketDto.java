package com.example.carparkingmanagementbe.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TicketDto implements Validator {
    private Long id;

    private String floor;

    @NotNull(message = "Vui lòng không để trống")
    private Double sumPrice;

    //    @NotEmpty(message = "Vui lòng không để trống")
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TicketDto ticketDto = (TicketDto) target;
        String inputBirthday = ticketDto.getEndDate();
        LocalDate birthDay = LocalDate.parse(inputBirthday, formatter);
        //  LocalDate birthdayToLocalDate = LocalDate.of(birthDay.getYear(),birthDay.getMonth(), birthDay.getDayOfMonth());
        LocalDate current = LocalDate.now();
        long betweenDate = ChronoUnit.DAYS.between(current, birthDay);
        if (ticketDto.getTicketType() != null) {
            if (ticketDto.getTicketType() == 1) {
                if (betweenDate != 1) {
                    errors.rejectValue("endDate", "", "Phải bằng 1");
                }
            } else if (ticketDto.getTicketType() == 2) {
                if (betweenDate < 30) {
                    errors.rejectValue("endDate", "", "Phải lớn hơn hoặc bằng 30 ngày");
                }
            }
            if (ticketDto.getTicketType() == null) {
                errors.rejectValue("ticketType", "", "Vé ko đưlocationể null");
            }

        }
    }

}

