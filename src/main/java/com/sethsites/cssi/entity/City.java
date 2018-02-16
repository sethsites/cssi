package com.sethsites.cssi.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 10:27 AM
 */
@Entity
public class City extends AbstractEntity {
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @OneToOne
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
