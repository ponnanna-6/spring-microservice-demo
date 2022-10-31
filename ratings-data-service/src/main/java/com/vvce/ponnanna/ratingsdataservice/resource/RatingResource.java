package com.vvce.ponnanna.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vvce.ponnanna.ratingsdataservice.model.Rating;
import com.vvce.ponnanna.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 5);
	}
	
	@RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId){
		List<Rating> rating= Arrays.asList(
				new Rating("1234", 4),
				new Rating("3456", 5)
				);
        UserRating userRating = new UserRating();
        userRating.setRatings(rating);
        return userRating;

    }
}
