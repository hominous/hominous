package com.hominous.familiar.crew.controller;


import com.hominous.familiar.crew.domain.Crew;
import com.hominous.familiar.crew.repository.CrewRepository;
import com.hominous.familiar.crew.repository.JpaCrewRepository;
import com.hominous.familiar.crew.dto.CrewCreateDto;
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

    //Spring config 말고 주입받고싶은데;;
    private final CrewRepository crewRepository;

    @Autowired
    public CrewController(JpaCrewRepository jpaCrewRepository) {
        this.crewRepository = jpaCrewRepository;
    }

    @GetMapping("/new")
    public String createForm() {return "crew/create-form";}

    @PostMapping
    public String createCrew(@ModelAttribute("crew") CrewCreateDto crewCreateDto){
        Crew crew = new Crew(crewCreateDto);
        crewRepository.save(crew);
        return "crew/welcome";
    }
}
