package com.sethsites.cssi.dto;

import com.sethsites.cssi.entity.CssiScore;
import com.sethsites.cssi.entity.CssiScoring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 2:21 PM
 */
public class CssiScoringDTO {
    Long id;
    Date scoringDate;
    int psycheCapabilityScore;
    int psycheWillScore;
    int physiologyCapabilityScore;
    int physiologyWillScore;
    int anatomyCapabilityScore;
    int anatomyWillScore;
    int relationalCapabilityScore;
    int relationalWillScore;
    List<CssiScoreDTO> cssiScores;

    public Long getId() {
        return id;
    }

    public Date getScoringDate() {
        return scoringDate;
    }

    public int getPsycheCapabilityScore() {
        return psycheCapabilityScore;
    }

    public int getPsycheWillScore() {
        return psycheWillScore;
    }

    public int getPhysiologyCapabilityScore() {
        return physiologyCapabilityScore;
    }

    public int getPhysiologyWillScore() {
        return physiologyWillScore;
    }

    public int getAnatomyCapabilityScore() {
        return anatomyCapabilityScore;
    }

    public int getAnatomyWillScore() {
        return anatomyWillScore;
    }

    public int getRelationalCapabilityScore() {
        return relationalCapabilityScore;
    }

    public int getRelationalWillScore() {
        return relationalWillScore;
    }

    public List<CssiScoreDTO> getCssiScores() {
        return cssiScores;
    }

    public static CssiScoringDTO toDTO(CssiScoring cssiScoring) {
        CssiScoringDTO dto = new CssiScoringDTO();
        dto.id = cssiScoring.getId();
        dto.scoringDate = cssiScoring.getScoreDate();
        dto.psycheCapabilityScore = cssiScoring.getPsycheCapabilityScore();
        dto.psycheWillScore = cssiScoring.getPsycheWillScore();
        dto.physiologyCapabilityScore = cssiScoring.getPhysiologyCapabilityScore();
        dto.physiologyWillScore = cssiScoring.getPhysiologyWillScore();
        dto.anatomyCapabilityScore = cssiScoring.getAnatomyCapabilityScore();
        dto.anatomyWillScore = cssiScoring.getAnatomyWillScore();
        dto.relationalCapabilityScore = cssiScoring.getRelationalCapabilityScore();
        dto.relationalWillScore = cssiScoring.getRelationalWillScore();

        dto.cssiScores = new ArrayList<>();
        for (CssiScore score : cssiScoring.getCssiScores()) {
            dto.cssiScores.add(CssiScoreDTO.toDTO(score));
        }

        return dto;
    }
}
