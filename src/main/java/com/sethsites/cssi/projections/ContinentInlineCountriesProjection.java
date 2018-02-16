package com.sethsites.cssi.projections;

import com.sethsites.cssi.entity.Continent;
import com.sethsites.cssi.entity.Country;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/14/18
 * Time: 7:22 PM
 */
@Projection(name = "inlineCountries", types = {Continent.class})
public interface ContinentInlineCountriesProjection {
    Long getId();
    String getName();
    List<Country> getCountries();
}
