package com.hominous.familiar.domain.crew.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewRepository extends JpaRepository<CrewEntity,Long> {

    boolean existsByCreatedBy(String createdBy);
}
