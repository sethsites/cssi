package com.sethsites.cssi.projections;

import com.sethsites.cssi.entity.CssiScore;
import com.sethsites.cssi.entity.Subvariable;
import com.sethsites.cssi.entity.Variable;
import org.springframework.data.rest.core.config.Projection;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 10:39 AM
 */
@Projection(name = "cssiScoreProjection", types = {CssiScore.class})
public interface CssiScoreProjection {
    Long getId();
    int getScore();
    Variable getVariable();
    Subvariable getSubvariable();
}
