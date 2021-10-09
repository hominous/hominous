package com.hominous.familiar.crew.repository;


import com.hominous.familiar.crew.domain.Crew;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;



public class MemoryCrewRepository implements CrewRepository {

    private static Map<Long, Crew> store = new HashMap<>();
    private static long sequence = 0L;

    public Crew save(Crew crew){
        crew.setId(++sequence);
        store.put(crew.getId(), crew);
        return crew;
    }
}
