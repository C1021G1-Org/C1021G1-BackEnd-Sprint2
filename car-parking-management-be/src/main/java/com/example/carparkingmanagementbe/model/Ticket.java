package com.example.carparkingmanagementbe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
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
    private String userEmail;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getImgCarIn() {
        return imgCarIn;
    }

    public void setImgCarIn(String imgCarIn) {
        this.imgCarIn = imgCarIn;
    }

    public String getImgCarOut() {
        return imgCarOut;
    }

    public void setImgCarOut(String imgCarOut) {
        this.imgCarOut = imgCarOut;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Boolean getDoing() {
        return isDoing;
    }

    public void setDoing(Boolean doing) {
        isDoing = doing;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
