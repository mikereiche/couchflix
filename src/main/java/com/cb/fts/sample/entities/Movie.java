package com.cb.fts.sample.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Movie implements Serializable {

    @Id
    private String id;
    private String originalLanguage;
    private String imdbId;
    private Boolean video;
    private String title;
    @Field("backdrop_path")
    private String backdropPath;
    private List<Credit> crew;
    private List<Actor> cast;
    private Double popularity;
    @Field("production_countries")
    private List<Country> productionCountries;
    @Field("vote_count")
    private Long voteCount;
    private Long budget;
    private Long revenue;
    private String overview;
    @Field("original_title")
    private String originalTitle;
    private Long runtime;
    // @Field("poster_path")
    private String posterPath;
    private List<Genre> genres;
    @Field("spoken_languages")
    private List<Language> spokenLanguages;
    @Field("production_companies")
    private List<Company> productionCompanies;
    @Field("release_date")
    private String releaseDate;
    @Field("release_year")
    private Integer releaseYear;
    @Field("vote_average")
    private Double voteAverage;
    private MovieCollection collection;
    private String tagline;
    private Boolean adult;
    private String homepage;
    private String status;
    private Boolean promoted;
    private double weightedRating;

    public String getId(){
        return id;
    }
    public String getTitle(){ return title;}

}
