package com.sethsites.cssi.repository;

import com.sethsites.cssi.entity.CssiScore;
import com.sethsites.cssi.projections.CssiScoreProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 10:38 AM
 */
@RepositoryRestResource(excerptProjection = CssiScoreProjection.class)
public interface CssiScoreRepository extends JpaRepository<CssiScore, Long> {
    List<CssiScore> findByCssiscoringId(@Param("id") Long id);
}
