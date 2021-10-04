package com.hominous.familiar.crew.repository;

import com.hominous.familiar.crew.domain.Crew;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpringDataJpaCrewRepository extends JpaRepository<Crew, Long>, CrewRepository {

    @Override
    Crew save(Crew crew);
}
