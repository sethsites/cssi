package com.sethsites.cssi.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 10:33 AM
 */
@Entity
@Table(name = "cssiscoring")
public class CssiScoring extends AbstractEntity {
    @Temporal(TemporalType.DATE)
    private Date scoreDate;

    @OneToOne
    private City city;
    
    private int psycheCapabilityScore;
    private int psycheWillScore;
    private int physiologyCapabilityScore;
    private int physiologyWillScore;
    private int anatomyCapabilityScore;
    private int anatomyWillScore;
    private int relationalCapabilityScore;
    private int relationalWillScore;

    @OneToMany(targetEntity = CssiScore.class, mappedBy = "cssiscoring")
    private List<CssiScore> cssiScores;

    @Transient
    private int willScore;

    @Transient
    private int capabilityScore;

    public Date getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getPsycheCapabilityScore() {
        return psycheCapabilityScore;
    }

    public void setPsycheCapabilityScore(int psycheCapabilityScore) {
        this.psycheCapabilityScore = psycheCapabilityScore;
        recalculateScores();
    }

    public int getPsycheWillScore() {
        return psycheWillScore;
    }

    public void setPsycheWillScore(int psycheWillScore) {
        this.psycheWillScore = psycheWillScore;
        recalculateScores();
    }

    public int getPhysiologyCapabilityScore() {
        return physiologyCapabilityScore;
    }

    public void setPhysiologyCapabilityScore(int physiologyCapabilityScore) {
        this.physiologyCapabilityScore = physiologyCapabilityScore;
        recalculateScores();
    }

    public int getPhysiologyWillScore() {
        return physiologyWillScore;
    }

    public void setPhysiologyWillScore(int physiologyWillScore) {
        this.physiologyWillScore = physiologyWillScore;
        recalculateScores();
    }

    public int getAnatomyCapabilityScore() {
        return anatomyCapabilityScore;
    }

    public void setAnatomyCapabilityScore(int anatomyCapabilityScore) {
        this.anatomyCapabilityScore = anatomyCapabilityScore;
        recalculateScores();
    }

    public int getAnatomyWillScore() {
        return anatomyWillScore;
    }

    public void setAnatomyWillScore(int anatomyWillScore) {
        this.anatomyWillScore = anatomyWillScore;
        recalculateScores();
    }

    public int getRelationalCapabilityScore() {
        return relationalCapabilityScore;
    }

    public void setRelationalCapabilityScore(int relationalCapabilityScore) {
        this.relationalCapabilityScore = relationalCapabilityScore;
        recalculateScores();
    }

    public int getRelationalWillScore() {
        return relationalWillScore;
    }

    public void setRelationalWillScore(int relationalWillScore) {
        this.relationalWillScore = relationalWillScore;
        recalculateScores();
    }

    public List<CssiScore> getCssiScores() {
        return cssiScores;
    }

    public void setCssiScores(List<CssiScore> cssiScores) {
        this.cssiScores = cssiScores;
    }

    public void addCssiScore(CssiScore cssiScore) {
        cssiScores.add(cssiScore);
    }

    public int getWillScore() {
        return willScore;
    }

    public int getCapabilityScore() {
        return capabilityScore;
    }

    public void recalculateScores() {
        resetScores();
        for (CssiScore score : cssiScores) {
            Subsystem subsystem = score.getVariable().getIndicator().getSubsystem();
            if (subsystem.getName().equals("Psyche")) {
                if (score.getVariable().getType() == Variable.Type.WILL || score.getVariable().getType() == Variable.Type.BOTH) {
                    psycheWillScore += score.getScore();
                }
                if (score.getVariable().getType() == Variable.Type.CAPABILITY || score.getVariable().getType() == Variable.Type.BOTH) {
                    psycheCapabilityScore += score.getScore();
                }
            } else if (subsystem.getName().equals("Physiology")) {
                if (score.getVariable().getType() == Variable.Type.WILL || score.getVariable().getType() == Variable.Type.BOTH) {
                    physiologyWillScore += score.getScore();
                }
                if (score.getVariable().getType() == Variable.Type.CAPABILITY || score.getVariable().getType() == Variable.Type.BOTH) {
                    physiologyCapabilityScore += score.getScore();
                }
            } else if (subsystem.getName().equals("Anatomy")) {
                if (score.getVariable().getType() == Variable.Type.WILL || score.getVariable().getType() == Variable.Type.BOTH) {
                    anatomyWillScore += score.getScore();
                }
                if (score.getVariable().getType() == Variable.Type.CAPABILITY || score.getVariable().getType() == Variable.Type.BOTH) {
                    anatomyCapabilityScore += score.getScore();
                }
            } else if (subsystem.getName().equals("Relational")) {
                if (score.getVariable().getType() == Variable.Type.WILL || score.getVariable().getType() == Variable.Type.BOTH) {
                    relationalWillScore += score.getScore();
                }
                if (score.getVariable().getType() == Variable.Type.CAPABILITY || score.getVariable().getType() == Variable.Type.BOTH) {
                    relationalCapabilityScore += score.getScore();
                }
            }
        }

        willScore = physiologyWillScore + psycheWillScore + anatomyWillScore + relationalWillScore;
        capabilityScore = physiologyCapabilityScore + psycheCapabilityScore + anatomyCapabilityScore + relationalCapabilityScore;
    }

    private void resetScores() {
        physiologyWillScore = 0;
        psycheWillScore = 0;
        anatomyWillScore = 0;
        relationalWillScore = 0;
        physiologyCapabilityScore = 0;
        psycheCapabilityScore = 0;
        anatomyCapabilityScore = 0;
        relationalCapabilityScore = 0;
        willScore = 0;
        capabilityScore = 0;
    }
}
