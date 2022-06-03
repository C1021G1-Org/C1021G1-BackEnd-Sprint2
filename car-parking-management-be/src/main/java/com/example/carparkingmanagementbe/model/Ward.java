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
@Table(name = "ward")
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String prefix;
    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id")
    private District district;

//    @ManyToOne
//    @JoinColumn(name = "id_province", referencedColumnName = "id")
//    private Province province;

    @JsonBackReference
    @OneToMany(mappedBy = "ward")
    private Set<Customer> customerSet;
    @JsonBackReference
    @OneToMany(mappedBy = "ward")
    private Set<Employee> employeeSet;
}
