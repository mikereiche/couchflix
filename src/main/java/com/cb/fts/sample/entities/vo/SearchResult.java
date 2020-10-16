package com.cb.fts.sample.entities.vo;

import com.cb.fts.sample.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SearchResult implements Serializable {

    private Movie movie;
    private QueryStats stats;
}
