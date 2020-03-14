package com.meynier.spring.graphql.repository;

import com.meynier.spring.graphql.model.Family;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FamilyRepository extends PagingAndSortingRepository<Family, Long> {
    Family findByName(String name);
}
