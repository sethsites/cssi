package com.sethsites.cssi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 10:20 AM
 */
@Entity
public class Country extends AbstractEntity {
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @OneToOne
    private Continent continent;

    @OneToMany(targetEntity = City.class, mappedBy = "country", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public List<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        if (cities == null) {
            cities = new ArrayList<>();
        }
        cities.add(city);
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
