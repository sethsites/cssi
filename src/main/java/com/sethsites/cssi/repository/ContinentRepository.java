package com.sethsites.cssi.repository;

import com.sethsites.cssi.entity.Continent;
import com.sethsites.cssi.projections.ContinentInlineCountriesProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 10:23 AM
 */
@RepositoryRestResource(excerptProjection = ContinentInlineCountriesProjection.class)
public interface ContinentRepository extends PagingAndSortingRepository<Continent, Long> {
    Optional<Continent> findByName(@Param("name") String name);
}
