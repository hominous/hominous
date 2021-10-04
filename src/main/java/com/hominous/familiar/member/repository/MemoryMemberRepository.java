package com.hominous.familiar.member.repository;

import com.hominous.familiar.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;



public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
}
