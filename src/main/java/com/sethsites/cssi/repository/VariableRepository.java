package com.sethsites.cssi.repository;

import com.sethsites.cssi.entity.Variable;
import com.sethsites.cssi.projections.VariableIndicatorProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * User: Seth Sites
 * Date: 2/14/18
 * Time: 3:01 PM
 */
@RepositoryRestResource(excerptProjection = VariableIndicatorProjection.class)
public interface VariableRepository extends PagingAndSortingRepository<Variable, Long> {
    Optional<Variable> findByIndicatorIdAndName(@Param("id") Long indicatorId, @Param("name") String name);
    List<Variable> findByIndicatorId(@Param("id") Long indicatorId);
}
