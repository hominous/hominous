package com.hominous.familiar.member.repository;

import com.hominous.familiar.member.domain.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();
    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository(){}

    public Member save(Member member) {
        member.setDbId(++sequence);
        store.put(member.getDbId(), member);
        return member;
    }
}
