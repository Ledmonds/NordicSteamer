package com.ledmonds.nordicsteamer.entity;

import javax.persistence.Entity;

@Entity
public class CountryRegion extends BaseEntity {
    private String name;
    private String nativeName;
    private String description;

    public CountryRegion() {}

    public CountryRegion(String name, String nativeName, String description) {
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
