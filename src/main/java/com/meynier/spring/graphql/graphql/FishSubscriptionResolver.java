package com.meynier.spring.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.meynier.spring.graphql.model.Family;
import com.meynier.spring.graphql.service.FamilyPublisher;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FishSubscriptionResolver implements GraphQLSubscriptionResolver {

    private final FamilyPublisher familyPublisher;

    @Autowired
    public FishSubscriptionResolver(FamilyPublisher familyPublisher) {
        this.familyPublisher = familyPublisher;
    }

    public Publisher<Family> lastFamily(){
        return familyPublisher.getPublisher();
    }
}
