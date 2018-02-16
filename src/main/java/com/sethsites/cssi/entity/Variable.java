package com.sethsites.cssi.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 11:12 AM
 */
@Entity
public class Variable extends AbstractEntity {
    public enum Type { NONE,CAPABILITY, WILL, BOTH }
    
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @OneToOne
    private Indicator indicator;

    @NotNull
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator indicator) {
        this.indicator = indicator;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
