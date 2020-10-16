package com.cb.fts.sample;

import com.cb.fts.sample.entities.Movie;
import com.cb.fts.sample.entities.vo.Result;
import com.cb.fts.sample.entities.vo.SearchResult;
import com.cb.fts.sample.service.MovieService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieSearchIntegrationTest extends SampleApplicationTests {

    @Autowired
    private MovieService movieService;

//
//    @Test
//    public void testSearch(){
//
//        List<SearchResult> movies = movieService.searchQuery("star trek");
//        printResults(movies);
//    }
//
//    @Test
//    public void testSearchMispelling(){
//
//        List<SearchResult> movies = movieService.searchQuery("start trek");
//        printResults(movies);
//    }

//    @Test
//    public void testMatchAllFields(){
//
//        List<SearchResult> movies = movieService.searchMatch1Field("book");
//        printResults(movies);
//    }



//    /*********************************************************************/
//
//
    /*
    @Test
    public void testSearchTitleLike(){
        Result movieResult = movieService.searchResultByTitleLike("Star Trek%");
        printResults(movieResult.getResults());
    }
    */


/*
    public void testSearchOriginalTitle(){
        List<Movie> movies = movieService.findByTitleLike("Star Trek%");
        int i=0;
       for(Movie movie:movies){
           System.out.println(""+(++i)+" "+movie.getTitle());
       }
    }
 */

//
//
//    /*********************************************************************/
//
//
//    @Test
//    public void testSearchOriginalTitleAndOverview(){
//
//        List<SearchResult> movies = movieService.searchMatch2Field("star trek");
//        printResults(movies);
//    }
//
//
//    @Test
//    public void testSearchOriginalTitleAndOverviewBoost(){
//
//        List<SearchResult> movies = movieService.searchMatch2Field("star trek");
//        printResults(movies);
//    }



    public void printResults(List<SearchResult> movies){
        int counter = 1;
        for(SearchResult result: movies) {
            System.out.println(counter+") "+result.getMovie().getTitle());
            //printRow(result.getRow());
            System.out.println("");
            counter++;
        }
    }

    public void printRow(Movie  row){ // this arg was SearchQueryResult (?)
        String padding = "     ";
        String doublePadding = padding+padding;
        System.out.println(padding+"id: "+row.getId());

        //System.out.println(padding+"Hit Locations: ");
/*
        for (HitLocation hitLocation: row.locations().getAll()) {
            System.out.println(doublePadding+"field:"+ hitLocation.field() );
            System.out.println(doublePadding+"term:"+ hitLocation.term() );
            System.out.println(doublePadding+"fragment:"+ row.fragments().get(hitLocation.field()));
            System.out.println(doublePadding+"-----------------------------");
        }
 */
    }
}
