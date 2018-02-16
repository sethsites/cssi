package com.sethsites.cssi.projections;

import com.sethsites.cssi.entity.City;
import com.sethsites.cssi.entity.CssiScoring;
import org.springframework.data.rest.core.config.Projection;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 10:27 AM
 */
@Projection(name = "cssiScoring", types = {CssiScoring.class})
public interface CssiScoringProjection {
    Long getId();
    City getCity();
    int getCapabilityScore();
    int getWillScore();
    int getPsycheCapabilityScore();
    int getPsycheWillScore();
    int getPhysiologyCapabilityScore();
    int getPhysiologyWillScore();
    int getAnatomyCapabilityScore();
    int getAnatomyWillScore();
    int getRelationalCapabilityScore();
    int getRelationalWillScore();
}
