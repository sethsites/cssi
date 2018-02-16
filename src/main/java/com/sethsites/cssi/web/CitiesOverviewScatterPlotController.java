package com.sethsites.cssi.web;

import com.sethsites.cssi.dto.CitiesOverviewScatterPlotDTO;
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
 * Time: 4:44 PM
 */
@Controller
@RequestMapping("citiesScatterPlot")
public class CitiesOverviewScatterPlotController {
    private final CssiScoringRepository cssiScoringRepository;

    @Autowired
    public CitiesOverviewScatterPlotController(CssiScoringRepository cssiScoringRepository) {
        this.cssiScoringRepository = cssiScoringRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CitiesOverviewScatterPlotDTO> getPlots(@RequestParam(name = "id", required = false) Long id) {
        List<CitiesOverviewScatterPlotDTO> plots = new ArrayList<>();
        if (id == null) {
            for (CssiScoring scoring : cssiScoringRepository.findAll()) {
                scoring.recalculateScores();
                plots.add(CitiesOverviewScatterPlotDTO.toDTO(scoring));
            }
        }
        return plots;
    }
}

