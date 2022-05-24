package com.example.carparkingmanagementbe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "allowed_car_parking")
public class AllowedCarParking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean carFourSeats;
    private Boolean carSevenSeats;
    private Boolean carTwelveSeats;
    private Boolean carOtherType;
    private String description;
    @ManyToMany(mappedBy = "allowedCarParkingSet")
    private Set<Location> locationSet;
}
