package com.hominous.familiar.domains.member.application;


import com.hominous.familiar.domains.crew.domain.CrewEntity;
import com.hominous.familiar.domains.crew.domain.CrewRepository;
import com.hominous.familiar.domains.member.application.dto.MemberCreateCrewRequest;
import com.hominous.familiar.domains.member.domain.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCreateCrewService {

  private final CrewRepository crewRepository;
  private final MemberFindService memberFindService;

  public CrewEntity makeCrew(Long memberIndex, MemberCreateCrewRequest memberCreateCrewRequest) {
    MemberEntity memberEntity = memberFindService.findById(memberIndex);
    String name = memberCreateCrewRequest.getName();
    CrewEntity crewEntity = CrewEntity
        .builder()
        .name(name)
        .createdBy(memberEntity.getName())
        .build();
    return crewRepository.save(crewEntity);
  }
}
