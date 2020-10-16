package com.cb.fts.sample.entities.vo;

import com.couchbase.client.java.search.result.SearchRow;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class QueryStats implements Serializable {

    private String id;
    private int position;
    private double score;
    private Map<String, Object> explanation;
    private Map<String, List<String>> fragments;
    private Map<String, String> fields;


    public QueryStats(int position, SearchRow row) {
        this.position = position;
        this.id = row.id();
        this.score = row.score();
        this.fragments = row.fragments();
        this.fields = row.fieldsAs( Map.class); // NPE here is fixed in 3.0.7 java client
        this.explanation = row.explanation()!= null ? row.explanation().toMap():null;
    }
}
