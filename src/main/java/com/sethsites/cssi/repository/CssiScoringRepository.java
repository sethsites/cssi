package com.sethsites.cssi.repository;

import com.sethsites.cssi.entity.CssiScoring;
import com.sethsites.cssi.projections.CssiScoringProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/15/18
 * Time: 10:25 AM
 */
@RepositoryRestResource(excerptProjection = CssiScoringProjection.class)
public interface CssiScoringRepository extends PagingAndSortingRepository<CssiScoring, Long>{
    List<CssiScoring> findByCityId(Long cityId);
}
