package com.example.carparkingmanagementbe.dto;

public interface CarTicketDto {
    String getCarPlate();
    String getCarName();
    String getCustomerName();
    Long getIdTicketType();
    String getCarCompany();
    String getCustomerPhone();
    String getStartDate();
    String getEndDate();
    Long getIdFloor();
    String getCode();
    String getImgCarIn();
    String getImgCarOut();
}
