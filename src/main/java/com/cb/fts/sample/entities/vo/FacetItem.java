package com.cb.fts.sample.entities.vo;

import com.couchbase.client.java.search.result.SearchTermRange;

import lombok.Data;

import java.io.Serializable;

@Data
public class FacetItem implements Serializable {

    private String name;
    private Long total;

    public FacetItem(SearchTermRange termRange) {
        this.name = termRange.name();
        this.total = termRange.count();
    }
}
