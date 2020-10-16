package com.cb.fts.sample.service;

import lombok.Data;
import lombok.ToString;

import java.util.*;
import java.util.regex.Pattern;

@ToString
@Data
public class EntityExtractor {

    private String words;
    private String originalQuery;
    private Map<EntityType, ArrayList<String>> entities = new HashMap<>();

    public EntityExtractor(String words) {

        words =  words.replaceAll(" +", " ");
        this.words = words.toLowerCase().trim();
        this.originalQuery = words.toLowerCase().trim();
    }

    public void addEntity(EntityType type, String text ){

        Pattern p = Pattern.compile("\\b" + text.toLowerCase() + "\\b");//replace ignores case
        this.words = p.matcher(words).replaceAll("");

        if(entities.get(type) == null) {
            entities.put(type, new ArrayList<>(Arrays.asList(text)));
        } else {
            entities.get(type).add(text);
        }
    }

    public String getWords(){
        return words;
    }

    public Map<EntityType, ArrayList<String>> getEntities() {
        return entities;
    }

    public enum EntityType {
        PERSON,
        ORGANIZATION,
        GENRES
    }

}
