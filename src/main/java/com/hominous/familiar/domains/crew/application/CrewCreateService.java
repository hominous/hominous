package com.hominous.familiar.domains.crew.application;


import com.hominous.familiar.domains.crew.application.dto.CrewCreateRequest;
import com.hominous.familiar.domains.crew.domain.CrewEntity;
import com.hominous.familiar.domains.crew.domain.CrewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrewCreateService {

    private final CrewRepository crewRepository;

    public void createCrew(CrewCreateRequest crewCreateRequest){
        CrewEntity crewEntity = CrewEntity.builder()
                .name(crewCreateRequest.getName())
                .createdBy(crewCreateRequest.getCreatedBy())
                .build();
        crewRepository.save(crewEntity);
    }
}
