package com.hominous.familiar.member.repository;

import com.hominous.familiar.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>{

    @Override
    Member save(Member member);

    @Override
    Optional<Member> findById(Long id);
    Optional<Member> findByUserId(String userId);
}
