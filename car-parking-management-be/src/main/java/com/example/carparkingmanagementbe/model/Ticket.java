package com.example.carparkingmanagementbe.model;

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
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Column(columnDefinition = "DATE")
    private String startDate;
    @Column(columnDefinition = "DATE")
    private String endDate;
    @Column(columnDefinition = "LONGTEXT")
    private String imgCarIn;
    @Column(columnDefinition = "LONGTEXT")
    private String imgCarOut;
    @Column(columnDefinition = "DATETIME")
    private String timeIn;
    @Column(columnDefinition = "DATETIME")
    private String timeOut;
    private Boolean delFlag;
    private Boolean isDoing;
    private Double sumPrice;
    @ManyToOne
    @JoinColumn(name = "id_ticket_type", referencedColumnName = "id")
    private TicketType ticketType;
    @OneToOne
    @JoinColumn(name = "id_location", referencedColumnName = "id")
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_car", referencedColumnName = "id")
    private Car car;
}
