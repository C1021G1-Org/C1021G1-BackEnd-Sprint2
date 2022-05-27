package com.example.carparkingmanagementbe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Long number;
    private Double length;
    private Double width;
    private Double height;
    private Boolean delFlag;
    private Boolean isEmpty;
    private String description;

    @OneToOne(mappedBy = "location")
    @JsonBackReference
    private Ticket ticket;

    @ManyToMany
    @JoinTable(name = "location_allowed_car_parking",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "allowed_car_parking_id")
    )
    private Set<AllowedCarParking> allowedCarParkingSet;

    @ManyToOne
    @JoinColumn(name = "id_floor", referencedColumnName = "id")
    private Floor floor;
}

