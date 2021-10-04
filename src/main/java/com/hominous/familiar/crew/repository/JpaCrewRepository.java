package com.hominous.familiar.crew.repository;

import com.hominous.familiar.crew.domain.Crew;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


public class JpaCrewRepository implements CrewRepository{

    private final EntityManager em;
    public JpaCrewRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Crew save(Crew crew) {
        em.persist(crew);
        return crew;
    }
}
