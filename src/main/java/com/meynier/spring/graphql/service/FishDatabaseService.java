package com.meynier.spring.graphql.service;

import com.meynier.spring.graphql.model.Family;
import com.meynier.spring.graphql.model.Fish;
import com.meynier.spring.graphql.repository.FamilyRepository;
import com.meynier.spring.graphql.repository.FishEntityManagerRepository;
import com.meynier.spring.graphql.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishDatabaseService {

    private final FishRepository fishRepository;

    private final FishEntityManagerRepository fishEntityManagerRepository;

    private final FamilyRepository familyRepository;


    @Autowired
    public FishDatabaseService(FishRepository fishRepository,
                               FishEntityManagerRepository fishEntityManagerRepository,
                               FamilyRepository familyRepository) {
        this.fishRepository = fishRepository;
        this.fishEntityManagerRepository = fishEntityManagerRepository;
        this.familyRepository = familyRepository;
    }

    public Fish getMostExpensiveFish() {
        return fishRepository.getMostExpensiveFish();
    }

    public Fish findFishByName(String name) {
        return fishRepository.findByName(name);
    }

    public Family findFamilyByName(String name) {
        return familyRepository.findByName(name);
    }

    public Fish findByOffset(int offset) {
        return fishRepository.findByOffset(offset);
    }
    public List<Fish> findFish(PageRequest pageRequest) {
        return fishRepository.findAll(pageRequest).toList();
    }

    public List<Fish> findFish(long after, int limit) {
        return this.fishEntityManagerRepository.findFish(after, limit);
    }

}
