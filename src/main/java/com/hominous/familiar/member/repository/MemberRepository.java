package com.hominous.familiar.member.repository;

import com.hominous.familiar.member.domain.Member;



public interface MemberRepository {
    Member save(Member member);
}
