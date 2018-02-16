package com.sethsites.cssi.entity;

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
 * Time: 11:03 AM
 */
@Entity
public class Subsystem extends AbstractEntity {
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @OneToMany(targetEntity = Indicator.class, mappedBy = "subsystem", fetch = FetchType.EAGER)
    private List<Indicator> indicators;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Indicator> getIndicators() {
        return indicators;
    }

    public void addIndicator(Indicator indicator) {
        if (indicators == null) {
            indicators = new ArrayList<>();
        }
        indicators.add(indicator);
    }

    public void setIndicators(List<Indicator> indicators) {
        this.indicators = indicators;
    }
}
