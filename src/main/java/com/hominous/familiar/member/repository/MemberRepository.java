package com.hominous.familiar.member.repository;

import com.hominous.familiar.member.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {
    Member save(Member member);
}
