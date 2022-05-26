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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    @Column(columnDefinition = "DATE")
    private String birthday;
    private String idCard;
    private String email;
    private String phone;
    private String address;
    private Boolean gender;
    private Boolean delFlag;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Car> carSet;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "id_ward", referencedColumnName = "id")
    private Ward ward;
}

