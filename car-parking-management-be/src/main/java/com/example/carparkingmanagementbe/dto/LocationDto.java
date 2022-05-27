package com.example.carparkingmanagementbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    private Long id;

    private String code;

    private Long number;

    private Double length;

    private Double width;

    private Double height;

    private Boolean delFlag;

    private Boolean isEmpty;

    private String description;

    private Long id_ticket;

    private Long id_allowedCarParkingSet;

    private Long id_floor;

}
