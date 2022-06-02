package com.example.carparkingmanagementbe.model;

public class SumStatistic {
    private float sumPrice;
    private int time;

    public SumStatistic() {
    }

    public SumStatistic(float sumPrice, int time) {
        this.sumPrice = sumPrice;
        this.time = time;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
