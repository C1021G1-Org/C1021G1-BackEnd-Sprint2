package com.example.carparkingmanagementbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    private Long id;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^([A-Z]{1})(-)[0-9]{1,2}$", message = "Mã vị trí VD: A-1")
    private String code;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "vị trí phải nhập lớn hơn 0")
    private Long number;

    @NotNull(message = "Không được để trống")
    @Max(value = 10, message = "Diện tích quá mức cho phép")
    @Min(value = 0, message = "Diện tích phải lớn hơn 0")
    private Double length;

    @NotNull(message = "Không được để trống")
    @Max(value = 10, message = "Diện tích quá mức cho phép")
    @Min(value = 0, message = "Diện tích phải lớn hơn 0")
    private Double width;

    @NotNull(message = "Không được để trống")
    @Max(value = 10, message = "Diện tích quá mức cho phép")
    @Min(value = 0, message = "Diện tích phải lớn hơn 0")
    private Double height;

    private Boolean delFlag;

    private Boolean isEmpty;

    @Size(min = 1, max = 45, message = "Không được nhập quá 45 kí tự")
    private String description;

    private Long id_ticket;

    @NotBlank(message = "Không được để trống")
    private String id_allowedCarParkingSet;

    @NotNull(message = "không được để trống")
    private Long id_floor;

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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(Long id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getId_allowedCarParkingSet() {
        return id_allowedCarParkingSet;
    }

    public void setId_allowedCarParkingSet(String id_allowedCarParkingSet) {
        this.id_allowedCarParkingSet = id_allowedCarParkingSet;
    }

    public Long getId_floor() {
        return id_floor;
    }

    public void setId_floor(Long id_floor) {
        this.id_floor = id_floor;
    }
}
