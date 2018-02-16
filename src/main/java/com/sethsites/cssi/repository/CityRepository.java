package com.sethsites.cssi.repository;

import com.sethsites.cssi.entity.City;
import com.sethsites.cssi.projections.CityInlineProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/13/18
 * Time: 10:31 AM
 */
@RepositoryRestResource(excerptProjection = CityInlineProjection.class)
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    List<City> findByName(@Param("name") String name);
    List<City> findByCountryId(@Param("id") Long countryId);
    List<City> findByCountryName(@Param("countryName") String name);
}
