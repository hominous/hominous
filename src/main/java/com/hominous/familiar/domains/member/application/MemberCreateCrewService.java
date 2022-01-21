package com.hominous.familiar.domains.member.application;


import com.hominous.familiar.domains.crew.domain.CrewEntity;
import com.hominous.familiar.domains.crew.domain.CrewRepository;
import com.hominous.familiar.domains.member.domain.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCreateCrewService {

  private final CrewRepository crewRepository;
  private final MemberFindService memberFindService;

  public CrewEntity makeCrew(Long memberIndex, String name) {
    MemberEntity memberEntity = memberFindService.findById(memberIndex);
    CrewEntity crewEntity = CrewEntity
        .builder()
        .name(name)
        .createdBy(memberEntity.getName())
        .build();
    return crewRepository.save(crewEntity);
  }
}
