package com.sethsites.cssi.projections;

import com.sethsites.cssi.entity.City;
import org.springframework.data.rest.core.config.Projection;

/**
 * User: Seth Sites
 * Date: 2/14/18
 * Time: 10:06 PM
 */
@Projection(name = "cityInlineProjection", types = {City.class})
public interface CityInlineProjection {
    Long getId();
    String getName();
}
