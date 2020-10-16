package com.cb.fts.sample.repositories;

import com.cb.fts.sample.entities.Movie;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@N1qlPrimaryIndexed
@Repository
public interface ReactiveMovieRepository extends ReactiveSortingRepository<Movie, String> {

	@Query("#{#n1ql.selectEntity} where #{#n1ql.filter} limit 10")
	List<Movie> namedQuery();

	Mono<Movie> findById(String movieId);

	Flux<Movie> findByHomepage(String homepage);
}
