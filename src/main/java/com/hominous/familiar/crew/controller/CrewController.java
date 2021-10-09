package com.hominous.familiar.crew.controller;


import com.hominous.familiar.crew.domain.Crew;
import com.hominous.familiar.crew.repository.CrewRepository;
import com.hominous.familiar.crew.repository.JpaCrewRepository;
import com.hominous.familiar.crew.dto.CrewCreateDto;
import com.hominous.familiar.crew.repository.SpringDataJpaCrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Transactional
@Controller
@RequestMapping("/crew")
public class CrewController {

    private final SpringDataJpaCrewRepository springDataJpaCrewRepository;

    @Autowired
    public CrewController(SpringDataJpaCrewRepository springDataJpaCrewRepository) {
        this.springDataJpaCrewRepository = springDataJpaCrewRepository;
    }

    @GetMapping("/new")
    public String createForm() {return "crew/create-form";}

    @PostMapping
    public String createCrew(@ModelAttribute("crew") CrewCreateDto crewCreateDto){
        Crew crew = new Crew(crewCreateDto);
        springDataJpaCrewRepository.save(crew);
        return "crew/welcome";
    }
}
