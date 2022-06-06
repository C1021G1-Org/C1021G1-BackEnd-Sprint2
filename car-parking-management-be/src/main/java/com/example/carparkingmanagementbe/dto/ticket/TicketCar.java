package com.example.carparkingmanagementbe.dto.ticket;

public class TicketCar {
    String carPlate;
    String carName;
    String customerName;
    Long idTicketType;
    String carCompany;
    String customerPhone;
    String startDate;
    String endDate;
    Long idFloor;
    String code;
    String imgCarIn;
    String imgCarOut;
    String timeIn;
    String timeOut;
    String idLocation;
    String nameLocation;

    public TicketCar() {
    }

    public TicketCar(String carPlate, String carName, String customerName, Long idTicketType, String carCompany, String customerPhone, String startDate, String endDate, Long idFloor, String code, String imgCarIn, String imgCarOut, String timeIn, String timeOut, String idLocation, String nameLocation) {
        this.carPlate = carPlate;
        this.carName = carName;
        this.customerName = customerName;
        this.idTicketType = idTicketType;
        this.carCompany = carCompany;
        this.customerPhone = customerPhone;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idFloor = idFloor;
        this.code = code;
        this.imgCarIn = imgCarIn;
        this.imgCarOut = imgCarOut;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.idLocation = idLocation;
        this.nameLocation = nameLocation;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getIdTicketType() {
        return idTicketType;
    }

    public void setIdTicketType(Long idTicketType) {
        this.idTicketType = idTicketType;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getIdFloor() {
        return idFloor;
    }

    public void setIdFloor(Long idFloor) {
        this.idFloor = idFloor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImgCarIn() {
        return imgCarIn;
    }

    public void setImgCarIn(String imgCarIn) {
        this.imgCarIn = imgCarIn;
    }

    public String getImgCarOut() {
        return imgCarOut;
    }

    public void setImgCarOut(String imgCarOut) {
        this.imgCarOut = imgCarOut;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }
}
