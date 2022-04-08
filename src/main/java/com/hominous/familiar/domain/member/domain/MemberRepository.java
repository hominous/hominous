package com.hominous.familiar.domain.member.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    @EntityGraph(attributePaths = "authorityEntities")
    Optional<MemberEntity> findOneWithAuthorityEntitiesByMemberId(String memberId);
}
