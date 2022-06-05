package com.example.carparkingmanagementbe.model;

public class Statistic {
    private int quarter;
    private int year;

    public Statistic() {
    }

    public Statistic(int quarter, int year) {
        this.quarter = quarter;
        this.year = year;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
