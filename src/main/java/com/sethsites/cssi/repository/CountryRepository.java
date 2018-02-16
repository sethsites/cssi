package com.sethsites.cssi.repository;

import com.sethsites.cssi.entity.Country;
import com.sethsites.cssi.projections.CountryInlineCitiesProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 10:25 AM
 */
@RepositoryRestResource(excerptProjection = CountryInlineCitiesProjection.class)
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
    List<Country> findByContinentId(@Param("id") Long id);
    List<Country> findByContinentName(@Param("name") String name);
    Optional<Country> findByName(@Param("name") String name);
}
