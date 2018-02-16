package com.sethsites.cssi.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User: Seth Sites
 * Date: 2/14/18
 * Time: 2:31 PM
 */
@Entity
@Table(name = "cssiscore")
public class CssiScore extends AbstractEntity {
    @OneToOne
    private CssiScoring cssiscoring;

    @OneToOne
    private Variable variable;

    @OneToOne
    private Subvariable subvariable;

    private int score;

    @OneToOne(targetEntity = CssiScoring.class)
    public CssiScoring getCssiscoring() {
        return cssiscoring;
    }

    public void setCssiscoring(CssiScoring cssiScoring) {
        this.cssiscoring = cssiScoring;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Subvariable getSubvariable() {
        return subvariable;
    }

    public void setSubvariable(Subvariable subvariable) {
        this.subvariable = subvariable;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
