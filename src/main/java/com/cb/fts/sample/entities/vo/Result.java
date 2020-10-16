package com.cb.fts.sample.entities.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    private List<SearchResult> results;
    private List<Facet> facets;

  public void setResults(List<SearchResult> movies) {
    results = movies;
  }

  public void setFacets(List<Facet> facets) {
    this.facets = facets;
  }
}
