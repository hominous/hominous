package com.hominous.familiar.domain.member.service;


import com.hominous.familiar.domain.auth.domain.AuthorityEntity;
import com.hominous.familiar.domain.crew.domain.CrewEntity;
import com.hominous.familiar.domain.crew.domain.CrewRepository;
import com.hominous.familiar.domain.member.dto.MemberCreateCrewRequest;
import com.hominous.familiar.domain.member.domain.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberCreateCrewService {

  private final CrewRepository crewRepository;
  private final MemberFindService memberFindService;

  @Transactional
  public CrewEntity makeCrew(Long memberIndex, MemberCreateCrewRequest memberCreateCrewRequest) {
    MemberEntity memberEntity = memberFindService.findById(memberIndex);

    if(!crewRepository.existsByCreatedBy(memberEntity.getName())){
      AuthorityEntity authorityEntity = AuthorityEntity.builder()
              .authorityName("ROLE_CREW_MAKER")
              .build();
      memberEntity.addAuthority(authorityEntity);
    }

    CrewEntity crewEntity = CrewEntity
        .builder()
        .name(memberCreateCrewRequest.getName())
        .createdBy(memberEntity.getName())
        .crewType(memberCreateCrewRequest.getCrewType())
        .build();

    crewRepository.save(crewEntity);
    return memberEntity.addCrew(crewEntity);
  }
}
