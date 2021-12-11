package com.hominous.familiar.domains.crew.application;


import com.hominous.familiar.domains.crew.application.dto.CrewSignupRequest;
import com.hominous.familiar.domains.crew.domain.CrewEntity;
import com.hominous.familiar.domains.crew.domain.CrewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CrewSignupService {

    private final CrewRepository crewRepository;

    @Transactional
    public void createCrew(CrewSignupRequest crewSignupRequest) {
        CrewEntity crewEntity = CrewEntity.builder()
                .name(crewSignupRequest.getName())
                .createdBy(crewSignupRequest.getCreatedBy())
                .build();
        crewRepository.save(crewEntity);
    }
}
