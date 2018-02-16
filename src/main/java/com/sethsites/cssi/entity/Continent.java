package com.sethsites.cssi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 10:08 AM
 */
@Entity
public class Continent extends AbstractEntity {
    @Size(min = 1, max = 255)
    @NotNull
    private String name;

    @OneToMany(targetEntity = Country.class, mappedBy = "continent", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Country> countries = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
