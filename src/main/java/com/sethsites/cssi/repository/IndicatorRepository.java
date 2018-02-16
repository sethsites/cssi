package com.sethsites.cssi.repository;

import com.sethsites.cssi.entity.Indicator;
import com.sethsites.cssi.entity.Subsystem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * User: Seth Sites
 * Date: 2/14/18
 * Time: 3:00 PM
 */
@RepositoryRestResource
public interface IndicatorRepository extends PagingAndSortingRepository<Indicator, Long> {
    Optional<Indicator> findBySubsystemAndName(Subsystem subsystem, String name);
    List<Indicator> findBySubsystemName(@Param("name") String name);
}
