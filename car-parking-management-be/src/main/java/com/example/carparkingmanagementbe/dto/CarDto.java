package com.example.carparkingmanagementbe.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CarDto {

    private Long id;

    @ValidationCodeCar(message = "Mã xe đã tồn tại.")
    private String code;

    @NotNull(message = "Tên xe phải bắt buộc nhập.")
    @NotBlank(message = "Tên xe không được để trống.")
    @Size(min = 2, max = 50, message = "Tên xe phải dài trên 2 ký tự và không được nhiều hơn 50 ký tự.")
    private String name;

    @ValidationCarPlate(message = "Biển số xe đã tồn tại.")
    @NotNull(message = "Biển số xe phải bắt buộc nhập.")
    @NotBlank(message = "Biển số xe không được để trống.")
    @Pattern(regexp = "^([0-9]{2})+([A-Z])+([-])+([0-9]{3})+([0-9]{2})$", message = "Vui lòng nhập đúng định dạng. VD: 43A-43209")
    private String carPlate;

    @NotNull(message = "Hãng xe phải bắt buộc nhập.")
    @NotBlank(message = "Hãng xe không được để trống.")
    @Size(min = 2, max = 50, message = "Hãng xe phải dài trên 2 ký tự và không được nhiều hơn 50 ký tự.")
    private String carCompany;

    private Boolean delFlag;

    @NotNull(message = "Khách hàng phải bắt buộc nhập.")
    private Long customer;

    @NotNull(message = "Loại xe phải bắt buộc nhập.")
    private Long carType;

    public CarDto() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Long getCarType() {
        return carType;
    }

    public void setCarType(Long carType) {
        this.carType = carType;
    }
}
