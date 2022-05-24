package com.example.carparkingmanagementbe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    @Column(columnDefinition = "DATE")
    private String birthday;
    private Boolean gender;
    private String phone;
    private String address;
    private Boolean delFlag;
    @ManyToOne
    @JoinColumn(name = "id_ward", referencedColumnName = "id")
    private Ward ward;
    @ManyToOne
    @JoinColumn(name = "id_position", referencedColumnName = "id")
    private Position position;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Set<Car> carSet;
}
