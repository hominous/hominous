package com.hominous.familiar.crew.repository;

import com.hominous.familiar.crew.domain.Crew;
import org.springframework.stereotype.Repository;


public interface CrewRepository {
    Crew save(Crew crew);
}
