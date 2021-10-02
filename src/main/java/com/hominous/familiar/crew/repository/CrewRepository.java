package com.hominous.familiar.crew.repository;


import com.hominous.familiar.crew.domain.Crew;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;



public class CrewRepository {

    private static Map<Long, Crew> store = new HashMap<>();
    private static long sequence = 0L;

    private static final CrewRepository instance = new CrewRepository();
    public static CrewRepository getInstance() { return instance; }

    public CrewRepository() {
    }

    public Crew save(Crew crew){
        crew.setId(++sequence);
        store.put(crew.getId(), crew);
        return crew;
    }
}
