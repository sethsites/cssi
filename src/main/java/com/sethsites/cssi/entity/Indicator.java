package com.sethsites.cssi.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 11:05 AM
 */
@Entity
public class Indicator extends AbstractEntity {
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @OneToOne
    private Subsystem subsystem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subsystem getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(Subsystem subsystem) {
        this.subsystem = subsystem;
    }
    
}
