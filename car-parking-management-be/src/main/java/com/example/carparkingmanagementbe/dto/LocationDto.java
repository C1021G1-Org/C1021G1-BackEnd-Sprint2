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

}
