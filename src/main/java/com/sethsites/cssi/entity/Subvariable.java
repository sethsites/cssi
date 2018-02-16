package com.sethsites.cssi.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 11:18 AM
 */
@Entity
public class Subvariable extends AbstractEntity {
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @OneToOne
    private Variable variable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }
}
