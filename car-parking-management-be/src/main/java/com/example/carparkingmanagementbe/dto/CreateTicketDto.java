package com.example.carparkingmanagementbe.dto;

public class CreateTicketDto {
    private Long id;

    private String code;

    private String imgCarIn;


    private String imgCarOut;


    private String timeIn;


    private String timeOut;


    private String startDate;


    private String endDate;

    private Boolean delFlag;
    private Boolean isChecking;
    private Double sumPrice;

    private Long idTicketType;


    private Long idLocation;


    private Long car;

    private String carPlate;

    public CreateTicketDto() {
    }

    public CreateTicketDto(Long id, String code, String imgCarIn, String imgCarOut, String timeIn, String timeOut, String startDate, String endDate, Boolean delFlag, Boolean isChecking, Double sumPrice, Long ticketType, Long location, Long car, String carPlate) {
        this.id = id;
        this.code = code;
        this.imgCarIn = imgCarIn;
        this.imgCarOut = imgCarOut;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.startDate = startDate;
        this.endDate = endDate;
        this.delFlag = delFlag;
        this.isChecking = isChecking;
        this.sumPrice = sumPrice;
        this.idTicketType = ticketType;
        this.idLocation = location;
        this.car = car;
        this.carPlate = carPlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Boolean getChecking() {
        return isChecking;
    }

    public void setChecking(Boolean checking) {
        isChecking = checking;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Long getIdTicketType() {
        return idTicketType;
    }

    public void setIdTicketType(Long idTicketType) {
        this.idTicketType = idTicketType;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
}




