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
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String prefix;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "province")
    private Set<District> districtSet;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "province")
    private Set<Ward> wardSet;
}
