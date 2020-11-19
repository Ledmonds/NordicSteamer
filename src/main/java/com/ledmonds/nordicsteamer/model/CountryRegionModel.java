package com.ledmonds.nordicsteamer.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CountryRegionModel {
    @NotNull
    @NotBlank
    @ApiModelProperty(example = "Capital Region")
    private String name;

    @NotNull
    @NotBlank
    @ApiModelProperty(example = "Höfuðborgarsvæðið")
    private String nativeName;

    @NotNull
    @NotBlank
    @ApiModelProperty(example = "Greater Reykjavík (Icelandic: Höfuðborgarsvæðið, meaning \"The Capital Region\") is a region in southwestern Iceland that comprises the national capital Reykjavík and six municipalities around it.")
    private String description;

    public CountryRegionModel(String name, String nativeName, String description) {
        this.name = name;
        this.nativeName = nativeName;
        this.description = description;
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
}
