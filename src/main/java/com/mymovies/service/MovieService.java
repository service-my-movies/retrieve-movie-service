package com.mymovies.service;

import com.mymovies.dto.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService implements IMovieService {

	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);
	
	private RestTemplate restTemplate = new RestTemplate();

	public MovieDTO getAPI_Movie(String movie_id) {

		MovieDTO movie = null;

		try {

			movie = restTemplate.getForObject(BASE_URL+movie_id+API_KEY+Language, MovieDTO.class);

			if(movie.getBackdrop_path() != null) {
				movie.setPoster_path(BASE_URL_IMAGE+movie.getPoster_path());
			}

			if(movie.getPoster_path() != null) {
				movie.setBackdrop_path(BASE_URL_IMAGE+movie.getBackdrop_path());
			}

		} catch (Exception e) {
			LOGGER.error("Unexpected Error: getAPI_Movie: " + e);
		}

		return movie;

	}

	public String getAPI_MovieDetailAll(String movie_id) {

		String movie = null;

		try {
			movie = restTemplate.getForObject(BASE_URL+movie_id+API_KEY+Language, String.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error: getAPI_DetailAll: " + e);
		}

		return movie;

	}

}
