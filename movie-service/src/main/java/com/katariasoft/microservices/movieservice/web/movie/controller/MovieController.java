package com.katariasoft.microservices.movieservice.web.movie.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.katariasoft.microservices.movieservice.web.movie.beans.Cast;
import com.katariasoft.microservices.movieservice.web.movie.beans.MovieResource;

@RestController
public class MovieController {

	private static Map<Integer, MovieResource> movies = new HashMap<>();
	private static List<Cast> starCast = new ArrayList<>();
	private static List<Cast> directors = new ArrayList<>();
	private static List<Cast> producers = new ArrayList<>();
	private static List<Cast> musicDirectors = new ArrayList<>();

	static {

		starCast.add(new Cast("Ishaan", "Actor"));
		starCast.add(new Cast("Jhanvi", "Actress"));
		directors.add(new Cast("David dhawan", null));
		producers.add(new Cast("Karan", null));
		musicDirectors.add(new Cast("Ajay-Atul", null));

		movies.put(1, new MovieResource(1, "Hum", starCast, directors, producers, musicDirectors, "2018-July-12",
				"100 cr", "200 cr", "Hit", "4"));
		movies.put(2, new MovieResource(2, "Hum Tum", starCast, directors, producers, musicDirectors, "2018-July-12",
				"100 cr", "200 cr", "Hit", "4"));
		movies.put(3, new MovieResource(3, "Dhadak", starCast, directors, producers, musicDirectors, "2018-July-12",
				"100 cr", "200 cr", "Hit", "4"));
		movies.put(4, new MovieResource(4, "Shan", starCast, directors, producers, musicDirectors, "2018-July-12",
				"100 cr", "200 cr", "Hit", "4"));

	}

	@GetMapping("/movies")
	public ResponseEntity<List<MovieResource>> getAllMovies() {
		return ResponseEntity.ok().body(Collections.list(Collections.enumeration(movies.values())));
	}

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<MovieResource> getMovie(@PathVariable(name = "movieId") int movieId) {
		if (!movies.containsKey(movieId))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(movies.get(movieId));
	}

}
