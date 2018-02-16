package com.sethsites.cssi.projections;

import com.sethsites.cssi.entity.Subvariable;
import org.springframework.data.rest.core.config.Projection;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 2:05 PM
 */
@Projection(name = "subvariableProjection", types = {Subvariable.class})
public interface SubvariableProjection {
    Long getId();
    String getName();
}
