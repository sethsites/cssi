package com.sethsites.cssi.projections;

/**
 * User: Seth Sites
 * Date: 2/14/18
 * Time: 7:58 PM
 */

import com.sethsites.cssi.entity.City;
import com.sethsites.cssi.entity.Country;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineCities", types = {Country.class})
public interface CountryInlineCitiesProjection {
    Long getId();
    String getName();
    List<City> getCities();
}
