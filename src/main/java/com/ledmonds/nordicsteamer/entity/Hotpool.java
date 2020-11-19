package com.ledmonds.nordicsteamer.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Hotpool extends BaseEntity {
    private String name;
    private String nordicName;
    private String description;
    private double temperature;
    private double gpsX;
    private double gpsY;

    @ManyToOne
    private CountryRegion countryRegion;

    public Hotpool() {}

    public Hotpool(String name, String nordicName, String description, double temperature, double gpsX, double gpsY, CountryRegion countryRegion) {
        this.name = name;
        this.nordicName = nordicName;
        this.description = description;
        this.temperature = temperature;
        this.gpsX = gpsX;
        this.gpsY = gpsY;
        this.countryRegion = countryRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNordicName() {
        return nordicName;
    }

    public void setNordicName(String nordicName) {
        this.nordicName = nordicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getGpsX() {
        return gpsX;
    }

    public void setGpsX(double gpsX) {
        this.gpsX = gpsX;
    }

    public double getGpsY() {
        return gpsY;
    }

    public void setGpsY(double gpsY) {
        this.gpsY = gpsY;
    }

    public CountryRegion getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(CountryRegion countryRegion) {
        this.countryRegion = countryRegion;
    }
}
