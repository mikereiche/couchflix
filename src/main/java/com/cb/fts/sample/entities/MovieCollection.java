package com.cb.fts.sample.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCollection {


    private Long id;
    @Field("backdrop_path")
    private String backdropPath;
    private String name;

    @Field("poster_path")
    private String posterPath;
}
