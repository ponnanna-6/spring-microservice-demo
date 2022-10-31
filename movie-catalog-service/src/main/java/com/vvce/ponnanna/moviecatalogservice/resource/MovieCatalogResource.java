package com.vvce.ponnanna.moviecatalogservice.resource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vvce.ponnanna.moviecatalogservice.model.CatalogItem;
import com.vvce.ponnanna.moviecatalogservice.model.Movie;
import com.vvce.ponnanna.moviecatalogservice.model.Rating;
import com.vvce.ponnanna.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating ratings= restTemplate.getForObject("http://localhost:8613/ratings/user/"
		+ userId, UserRating.class);
		
		return ratings.getRatings().stream().map(rating -> {
			
                    Movie movie = restTemplate.getForObject("http://localhost:8612/movies/" 
                + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getMovieName(), "IAM IRON MAN", rating.getRating());
                })
                .collect(Collectors.toList());	
		
	}
}
