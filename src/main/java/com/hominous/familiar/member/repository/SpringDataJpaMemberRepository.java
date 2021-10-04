package com.hominous.familiar.member.repository;

import com.hominous.familiar.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    @Override
    Member save(Member member);
}
