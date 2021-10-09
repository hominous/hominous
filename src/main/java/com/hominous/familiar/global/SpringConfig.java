package com.hominous.familiar.global;


import com.hominous.familiar.crew.repository.CrewRepository;
import com.hominous.familiar.crew.repository.JpaCrewRepository;
import com.hominous.familiar.crew.repository.SpringDataJpaCrewRepository;
import com.hominous.familiar.member.repository.MemberRepository;
import com.hominous.familiar.member.repository.SpringDataJpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private final SpringDataJpaCrewRepository springDataJpaCrewRepository;
    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;

    @Autowired
    public SpringConfig(SpringDataJpaCrewRepository springDataJpaCrewRepository, SpringDataJpaMemberRepository springDataJpaMemberRepository) {
        this.springDataJpaCrewRepository = springDataJpaCrewRepository;
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
    }
}
