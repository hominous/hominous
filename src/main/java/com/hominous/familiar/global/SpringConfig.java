package com.hominous.familiar.global;


import com.hominous.familiar.crew.repository.CrewRepository;
import com.hominous.familiar.crew.repository.JpaCrewRepository;
import com.hominous.familiar.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private final CrewRepository crewRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(CrewRepository crewRepository, MemberRepository memberRepository) {
        this.crewRepository = crewRepository;
        this.memberRepository = memberRepository;
    }
}
