package com.sethsites.cssi.repository;

import com.sethsites.cssi.entity.Subsystem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * User: Seth Sites
 * Date: 2/14/18
 * Time: 2:58 PM
 */
@RepositoryRestResource
public interface SubsystemRepository extends PagingAndSortingRepository<Subsystem, Long> {
    Optional<Subsystem> findByName(@Param("name") String name);
}
