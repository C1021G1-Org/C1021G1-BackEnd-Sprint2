package com.example.carparkingmanagementbe.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateTicketDto {
    private Long id;
    @NotNull(message = "phải bắt buộc nhập!")
    @NotBlank(message = "không được để trống!")
    @Pattern(regexp = "^([TK-])+([0-9]{4})$", message = "Vui lòng nhập đúng định dạng. ([TK-]XXXX) trong đó X là số từ (0-9)!")

    private String code;
    @NotNull(message = "phải bắt buộc nhập!")
    @NotBlank(message = "không được để trống!")
    private String imgCarIn;

    @NotNull(message = "phải bắt buộc nhập!")
    @NotBlank(message = "không được để trống!")
    private String imgCarOut;

    @NotNull(message = "phải bắt buộc nhập!")
    @NotBlank(message = "không được để trống!")
    private String timeIn;

    @NotNull(message = "phải bắt buộc nhập!")
    @NotBlank(message = "không được để trống!")
    private String timeOut;

    @NotNull(message = "phải bắt buộc nhập!")
    @NotBlank(message = "không được để trống!")
    private String startDate;

    @NotNull(message = "phải bắt buộc nhập!")
    @NotBlank(message = "không được để trống!")
    private String endDate;

    private Boolean delFlag;
    private Boolean isDoing;
    private Double sumPrice;

    @NotNull(message = "phải bắt buộc nhập!")
    private Long ticketType;

    @NotNull(message = "phải bắt buộc nhập!")
    private Long location;

    @NotNull(message = "phải bắt buộc nhập!")
    private Long car;

    public CreateTicketDto() {
    }

    public CreateTicketDto(Long id, String code, String imgCarIn, String imgCarOut, String timeIn, String timeOut, String startDate, String endDate, Boolean delFlag, Boolean isDoing, Double sumPrice, Long ticketType, Long location, Long car) {
        this.id = id;
        this.code = code;
        this.imgCarIn = imgCarIn;
        this.imgCarOut = imgCarOut;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.startDate = startDate;
        this.endDate = endDate;
        this.delFlag = delFlag;
        this.isDoing = isDoing;
        this.sumPrice = sumPrice;
        this.ticketType = ticketType;
        this.location = location;
        this.car = car;
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
        return isDoing;
    }

    public void setChecking(Boolean checking) {
        isDoing = checking;
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

    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }
}




