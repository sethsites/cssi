package com.sethsites.cssi.dto;

import com.sethsites.cssi.entity.CssiScore;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 2:23 PM
 */
public class CssiScoreDTO {
    Long id;
    int score;
    Long variableId;
    Long subvariableId;

    public Long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public Long getVariableId() {
        return variableId;
    }

    public Long getSubvariableId() {
        return subvariableId;
    }

    public static CssiScoreDTO toDTO(CssiScore score) {
        CssiScoreDTO scoreDTO = new CssiScoreDTO();
        scoreDTO.id = score.getId();
        scoreDTO.score = score.getScore();
        scoreDTO.variableId = score.getVariable().getId();
        if (score.getSubvariable() != null)
            scoreDTO.subvariableId = score.getSubvariable().getId();
        return scoreDTO;
    }
}
