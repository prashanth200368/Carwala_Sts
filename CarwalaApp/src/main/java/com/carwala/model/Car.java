package com.carwala.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    private String name;
    private String brand;
    private int mfgYear;
    private double price;

    // Constructors, Getters, and Setters
    public Car() {}

    public Car(String name, String brand, int mfgYear, double price) {
        this.name = name;
        this.brand = brand;
        this.mfgYear = mfgYear;
        this.price = price;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMfgYear() {
        return mfgYear;
    }

    public void setMfgYear(int mfgYear) {
        this.mfgYear = mfgYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
