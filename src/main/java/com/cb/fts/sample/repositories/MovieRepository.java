package com.cb.fts.sample.repositories;

import com.cb.fts.sample.entities.Movie;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@N1qlPrimaryIndexed
@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, String> {

	@Query("#{#n1ql.selectEntity} where #{#n1ql.filter} name=$moviename")
	List<Movie> getMovies(@Param("moviename") String name);

  //	Optional<Movie> findById(String movieId);

	List<Movie> findByTitleLikeOrOriginalTitleLike(String title, String originalTitle);

	//Page<Movie>  findByTitleLike(String title, PageRequest pageRequest);

	List<Movie> findByTitleLike(String title);
}
