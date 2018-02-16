package com.sethsites.cssi.web;

import com.sethsites.cssi.dto.CityScatterPlotDTO;
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
 * Time: 3:25 PM
 */
@Controller
@RequestMapping("/cityScatterPlot")
public class CityScatterPlotController {
    private final CssiScoringRepository cssiScoringRepository;

    @Autowired
    public CityScatterPlotController(CssiScoringRepository cssiScoringRepository) {
        this.cssiScoringRepository = cssiScoringRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CityScatterPlotDTO> getPlots(@RequestParam(name = "id", required = false) Long id) {
        List<CityScatterPlotDTO> plots = new ArrayList<>();
        if (id == null) {
            for (CssiScoring scoring : cssiScoringRepository.findAll()) {
                scoring.recalculateScores();
                plots.add(CityScatterPlotDTO.toDTO(scoring));
            }
        }
        return plots;
    }
}
