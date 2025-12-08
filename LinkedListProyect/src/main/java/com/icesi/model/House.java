package com.icesi.model;

public class House {
    private double area;
    private int floor;

    public House(double area, int floor) {
        this.area = area;
        this.floor = floor;
    }


    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
