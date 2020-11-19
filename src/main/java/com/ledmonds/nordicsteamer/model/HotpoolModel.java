package com.ledmonds.nordicsteamer.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HotpoolModel {
    @NotNull
    @NotBlank
    @ApiModelProperty(example = "Blue Lagoon")
    private String name;

    @ApiModelProperty(example = "Bláa lónið")
    private String nativeName;

    @NotNull
    @NotBlank
    @ApiModelProperty(example = "The Blue Lagoon (Icelandic: \"Bláa lónið\") - the world's most famous geothermal spa and one of the most popular attractions in Iceland. Blue Lagoon was selected one of the 10 top spas in the world.")
    private String description;

    @Min(0)
    private double temperature;

    @Range(min = -180,max = 180)
    private double gpsX;

    @Range(min = -90,max = 90)
    private double gpsY;

    private Long countryRegionId;

    public HotpoolModel(String name, String nativeName, String description, double temperature, double gpsX, double gpsY, Long countryRegionId) {
        this.name = name;
        this.nativeName = nativeName;
        this.description = description;
        this.temperature = temperature;
        this.gpsX = gpsX;
        this.gpsY = gpsY;
        this.countryRegionId = countryRegionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
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

    public Long getCountryRegionIdRegion() {
        return countryRegionId;
    }

    public void setCountryRegionId(Long regionId) {
        this.countryRegionId = countryRegionId;
    }
}
