package com.sethsites.cssi.projections;

import com.sethsites.cssi.entity.Variable;
import org.springframework.data.rest.core.config.Projection;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 1:46 PM
 */
@Projection(name = "variableIndicatorProjection", types = {Variable.class})
public interface VariableIndicatorProjection {
    Long getId();
    String getName();
    Variable.Type getType();
}
