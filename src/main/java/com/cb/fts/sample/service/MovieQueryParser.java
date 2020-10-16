package com.cb.fts.sample.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cb.fts.sample.entities.ActorName;
import com.cb.fts.sample.repositories.ActorNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A probabilistic parser is potentially a better option here
 */

@Component
public class MovieQueryParser {

    @Autowired
    private ActorNameRepository actorNameRepository;

    private static final List<String> categories = Arrays.asList("comedy", "crime", "drama"
            , "science fiction", "romance", "horror", "thriller", "action"
            , "adventure", "fantasy", "mystery", "animation", "family", "foreign"
            , "documentary", "music", "history", "western", "tv movie");

    public EntityExtractor parse(String words) {
        EntityExtractor entityExtractor = new EntityExtractor(words);

        extractCategories(entityExtractor);
        extractEntities(entityExtractor);
        return entityExtractor;
    }


    private void extractEntities(EntityExtractor entityExtractor) {

        List<String> shingles = getShingles(entityExtractor.getWords());

        for(String shingle: shingles) {
            Optional<ActorName> actorName = actorNameRepository.findById(getActorNameId(shingle));
            if(actorName.isPresent()) {
                entityExtractor.addEntity(EntityExtractor.EntityType.PERSON, shingle);
            }

        }

    }


    private static void extractCategories(EntityExtractor entityExtractor) {

        for(String category: categories) {
            if(entityExtractor.getWords().toLowerCase().matches("(?s).*\\b"+category.toLowerCase()+"\\b.*")) {
                entityExtractor.addEntity(EntityExtractor.EntityType.GENRES, category );
            }
        }
    }


    private static List<String> getShingles(String words) {
        String[] w = words.split(" ");


        if(w.length == 0 || w.length == 1 ) {
            return new ArrayList<>();

        } else if(w.length == 2) {
            return  Arrays.asList(w[0]+ " " + w[1]);
        } else {
            List<String> shingles = new ArrayList<>();

            for (int i = 0; i < w.length - 1; i++) {

                shingles.add(w[i] +" "+w[i+1]);
            }

            return shingles;
        }
    }


    private static String getActorNameId(String name) {
        String prefix = "actorName-";

        String newName = Normalizer
                .normalize(name.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");

        return prefix+Arrays.asList(newName.split(" "))
                .stream()
                .map(e-> e.trim())
                .filter(e->!e.isEmpty())
                .collect(Collectors.joining("-"));
    }
}
