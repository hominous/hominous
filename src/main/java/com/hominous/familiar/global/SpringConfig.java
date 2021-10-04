package com.hominous.familiar.global;


import com.hominous.familiar.crew.repository.CrewRepository;
import com.hominous.familiar.crew.repository.JpaCrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    public CrewRepository crewRepository() {
        return new JpaCrewRepository(em);
    }
}
