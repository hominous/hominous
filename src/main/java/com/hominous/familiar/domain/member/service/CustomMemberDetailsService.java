package com.hominous.familiar.domain.member.service;

import com.hominous.familiar.domain.member.domain.MemberEntity;
import com.hominous.familiar.domain.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
@RequiredArgsConstructor
public class CustomMemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        return memberRepository.findOneWithAuthorityEntitiesByMemberId(memberId)
                .map(this::createUser)
                .orElseThrow(() -> new UsernameNotFoundException(memberId + " -> 식별불가능한 Member Id 입니다."));
    }

    private User createUser(MemberEntity memberEntity) {
        List<GrantedAuthority> grantedAuthorities = memberEntity.getAuthorityEntities().stream()
                .map(authorityEntity -> new SimpleGrantedAuthority(authorityEntity.getAuthorityName()))
                .collect(Collectors.toList());
        return new User(memberEntity.getMemberId(), memberEntity.getPassword(), grantedAuthorities);
    }
}
