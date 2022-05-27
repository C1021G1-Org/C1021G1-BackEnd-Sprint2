package com.example.carparkingmanagementbe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    private String carPlate;
    private String carCompany;



    private Boolean delFlag;
    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;
    @OneToOne(mappedBy = "car")
    @JsonBackReference
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "id_car_type", referencedColumnName = "id")
    private CarType carType;
}
