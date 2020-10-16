package com.cb.fts.sample.rest;


import com.cb.fts.sample.entities.Movie;
import com.cb.fts.sample.entities.vo.CoverVo;
import com.cb.fts.sample.entities.vo.Result;
import com.cb.fts.sample.repositories.MovieRepository;
import com.cb.fts.sample.repositories.ReactiveMovieRepository;
import com.cb.fts.sample.service.ImageService;
import com.cb.fts.sample.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.logging.Logger;

@CrossOrigin( maxAge = 3600)
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    Logger log = Logger.getLogger(MovieController.class.getName());

    @Autowired
    private ApplicationContext context;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result search(@RequestParam("query") String query, @RequestParam(value = "filters", required = false) String filters ) {
        log.info("/search?query="+query+"&filters="+filters);
        return movieService.searchQuery(query, filters);
    }

    @RequestMapping(value = "/getCover", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CoverVo getCover(@RequestParam("movieName") String query) throws Exception {
        log.info("/getCover?movieName="+query);
        return imageService.getImg(query);
    }

    @Autowired ReactiveMovieRepository locationDataRepository;
    @GetMapping(value="/LocationUpdates", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Movie> findLatestLocations(@RequestParam("id") String id){
        String dataType = "location";
        long t0 = System.currentTimeMillis();
        // 100
        // title: "Lock, Stock and Two Smoking Barrels"
        log.info("/LocationUpdates?id="+id);
        Mono<Movie> result =  locationDataRepository.findById(id).doOnSuccess((m) -> System.out.println(m));
        System.out.println(System.currentTimeMillis()-t0+" "+result.block());
        return result;
    }

}
