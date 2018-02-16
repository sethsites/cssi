package com.sethsites.cssi.repository;

import com.sethsites.cssi.entity.Subvariable;
import com.sethsites.cssi.projections.SubvariableProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * User: Seth Sites
 * Date: 2/14/18
 * Time: 3:04 PM
 */
@RepositoryRestResource(excerptProjection = SubvariableProjection.class)
public interface SubvariableRepository extends PagingAndSortingRepository<Subvariable, Long> {
    List<Subvariable> findByVariableId(@Param("id") Long id);
}
