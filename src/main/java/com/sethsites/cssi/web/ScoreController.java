package com.sethsites.cssi.web;

import com.sethsites.cssi.dto.CssiScoringDTO;
import com.sethsites.cssi.entity.CssiScoring;
import com.sethsites.cssi.repository.CssiScoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 2:16 PM
 */
@Controller
@RequestMapping("/score")
public class ScoreController {
    private final CssiScoringRepository cssiScoringRepository;

    @Autowired
    ScoreController(CssiScoringRepository cssiScoringRepository) {
        this.cssiScoringRepository = cssiScoringRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CssiScoringDTO> getScores(@RequestParam(name = "id", required = false) Long id) {
        List<CssiScoringDTO> scoringDTOS = new ArrayList<>();
        if (id == null) {
            for (CssiScoring scoring : cssiScoringRepository.findAll()) {
                scoring.recalculateScores();
                scoringDTOS.add(CssiScoringDTO.toDTO(scoring));
            }
        } else {
            CssiScoring cssiScoring = cssiScoringRepository.findOne(id);
            if (cssiScoring != null)
                cssiScoring.recalculateScores();
            scoringDTOS.add(CssiScoringDTO.toDTO(cssiScoring));
        }
        return scoringDTOS;
    }

}
