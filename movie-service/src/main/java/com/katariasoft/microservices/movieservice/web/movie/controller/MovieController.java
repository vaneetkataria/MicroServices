package com.katariasoft.microservices.movieservice.web.movie.controller;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.support.RequestContext;

import com.katariasoft.microservices.movieservice.web.movie.beans.Cast;
import com.katariasoft.microservices.movieservice.web.movie.beans.MovieResource;
import com.katariasoft.microservices.movieservice.web.movie.beans.Song;
import com.katariasoft.microservices.movieservice.web.movie.config.DefaultAdultMovie;
import com.katariasoft.microservices.movieservice.web.movie.config.DefaultArtMovie;
import com.katariasoft.microservices.movieservice.web.movie.config.DefaultBiopicMovie;
import com.katariasoft.microservices.movieservice.web.movie.config.DefaultMovie;
import com.katariasoft.microservices.movieservice.web.movie.config.EnvironmentAwareDefaultActionMovie;
import com.katariasoft.microservices.movieservice.web.movie.helper.feign.SongsServiceClient;

@RestController
public class MovieController {

	@Autowired
	private DefaultMovie defaultMovie;
	@Autowired
	private DefaultArtMovie defaultArtMovie;
	@Autowired
	private DefaultAdultMovie defaultActionMovie;
	@Autowired
	private EnvironmentAwareDefaultActionMovie environmentAwareDefaultActionMovie;
	@Autowired
	private DefaultBiopicMovie defaultBiopicMovie;
	@Autowired
	private SongsServiceClient songsServiceClient;
	@Autowired
	private RestTemplate restTemplate;

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

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

	@GetMapping("/movies")

	public ResponseEntity<List<MovieResource>> getAllMovies() {
		List<MovieResource> movieResources = Collections.list(Collections.enumeration(movies.values()));
		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(defaultMovie.getActor(), "Actor"));
		starCast.add(new Cast(defaultMovie.getActoress(), "Actoress"));
		movieResources.add(new MovieResource(defaultMovie.getId(), defaultMovie.getName(), starCast, null, null, null,
				defaultMovie.getReleaseDate(), defaultMovie.getBudget(), defaultMovie.getGrossIncome(),
				defaultMovie.getVerdict(), defaultMovie.getStarRating()));
		return ResponseEntity.ok().body(movieResources);
	}

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<MovieResource> getMovie(@PathVariable(name = "movieId") int movieId) {
		if (!movies.containsKey(movieId))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(movies.get(movieId));
	}

	@GetMapping("/movies/default")
	public ResponseEntity<MovieResource> getDefaultMovie() {
		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(defaultMovie.getActor(), "Actor"));
		starCast.add(new Cast(defaultMovie.getActoress(), "Actoress"));
		return ResponseEntity.ok()
				.body(new MovieResource(defaultMovie.getId(), defaultMovie.getName(), starCast, null, null, null,
						defaultMovie.getReleaseDate(), defaultMovie.getBudget(), defaultMovie.getGrossIncome(),
						defaultMovie.getVerdict(), defaultMovie.getStarRating()));
	}

	@GetMapping("/movies/art")
	public ResponseEntity<List<MovieResource>> getAllArtMovies() {
		List<MovieResource> movieResources = new ArrayList<>();
		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(defaultArtMovie.getActor(), "Actor"));
		starCast.add(new Cast(defaultArtMovie.getActress(), "Actoress"));
		movieResources.add(new MovieResource(defaultArtMovie.getId(), defaultArtMovie.getName(), starCast, null, null,
				null, defaultArtMovie.getReleaseDate(), defaultArtMovie.getBudget(), defaultArtMovie.getGrossIncome(),
				defaultArtMovie.getVerdict(), defaultArtMovie.getStarRating()));
		return ResponseEntity.ok().body(movieResources);
	}

	@GetMapping("/movies/art/default")
	public ResponseEntity<MovieResource> getDefaultArtMovie() {
		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(defaultArtMovie.getActor(), "Actor"));
		starCast.add(new Cast(defaultArtMovie.getActress(), "Actoress"));
		return ResponseEntity.ok()
				.body(new MovieResource(defaultArtMovie.getId(), defaultArtMovie.getName(), starCast, null, null, null,
						defaultArtMovie.getReleaseDate(), defaultArtMovie.getBudget(), defaultArtMovie.getGrossIncome(),
						defaultArtMovie.getVerdict(), defaultArtMovie.getStarRating()));
	}

	@GetMapping("/movies/adult")
	public ResponseEntity<List<MovieResource>> getAllActionMovies() {
		List<MovieResource> movieResources = new ArrayList<>();
		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(defaultActionMovie.getActor(), "Actor"));
		starCast.add(new Cast(defaultActionMovie.getActoress(), "Actoress"));
		movieResources.add(new MovieResource(defaultActionMovie.getId(), defaultActionMovie.getName(), starCast, null,
				null, null, defaultActionMovie.getReleaseDate(), defaultActionMovie.getBudget(),
				defaultActionMovie.getGrossIncome(), defaultActionMovie.getVerdict(),
				defaultActionMovie.getStarRating()));
		return ResponseEntity.ok().body(movieResources);
	}

	@GetMapping("/movies/adult/default")
	public ResponseEntity<MovieResource> getDefaultActionMovie() {
		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(defaultActionMovie.getActor(), "Actor"));
		starCast.add(new Cast(defaultActionMovie.getActoress(), "Actoress"));
		return ResponseEntity.ok()
				.body(new MovieResource(defaultActionMovie.getId(), defaultActionMovie.getName(), starCast, null, null,
						null, defaultActionMovie.getReleaseDate(), defaultActionMovie.getBudget(),
						defaultActionMovie.getGrossIncome(), defaultActionMovie.getVerdict(),
						defaultActionMovie.getStarRating()));
	}

	@GetMapping("/movies/environmentaware/action")
	public ResponseEntity<List<MovieResource>> getAlleaActionMovies() {
		List<MovieResource> movieResources = new ArrayList<>();
		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(environmentAwareDefaultActionMovie.getActor(), "Actor"));
		starCast.add(new Cast(environmentAwareDefaultActionMovie.getActoress(), "Actoress"));
		movieResources.add(new MovieResource(environmentAwareDefaultActionMovie.getId(),
				environmentAwareDefaultActionMovie.getName(), starCast, null, null, null,
				environmentAwareDefaultActionMovie.getReleaseDate(), environmentAwareDefaultActionMovie.getBudget(),
				environmentAwareDefaultActionMovie.getGrossIncome(), environmentAwareDefaultActionMovie.getVerdict(),
				environmentAwareDefaultActionMovie.getStarRating()));
		return ResponseEntity.ok().body(movieResources);
	}

	@GetMapping("/movies/environmentaware/action/default")
	public ResponseEntity<MovieResource> getDefaulteaActionMovie() {
		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(environmentAwareDefaultActionMovie.getActor(), "Actor"));
		starCast.add(new Cast(environmentAwareDefaultActionMovie.getActoress(), "Actoress"));
		return ResponseEntity.ok().body(new MovieResource(environmentAwareDefaultActionMovie.getId(),
				environmentAwareDefaultActionMovie.getName(), starCast, null, null, null,
				environmentAwareDefaultActionMovie.getReleaseDate(), environmentAwareDefaultActionMovie.getBudget(),
				environmentAwareDefaultActionMovie.getGrossIncome(), environmentAwareDefaultActionMovie.getVerdict(),
				environmentAwareDefaultActionMovie.getStarRating()));
	}

	@GetMapping("/movies/folderenvaware/boipic")
	public ResponseEntity<List<MovieResource>> getAllBoipicMovies() {
		List<MovieResource> movieResources = new ArrayList<>();
		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(defaultBiopicMovie.getActor(), "Actor"));
		starCast.add(new Cast(defaultBiopicMovie.getActoress(), "Actoress"));
		movieResources.add(new MovieResource(defaultBiopicMovie.getId(), defaultBiopicMovie.getName(), starCast, null,
				null, null, defaultBiopicMovie.getReleaseDate(), defaultBiopicMovie.getBudget(),
				defaultBiopicMovie.getGrossIncome(), defaultBiopicMovie.getVerdict(),
				defaultBiopicMovie.getStarRating()));
		return ResponseEntity.ok().body(movieResources);
	}

	@GetMapping("/movies/folderenvaware/boipic/default")
	public ResponseEntity<MovieResource> getDefaultBoipicMovie() {

		List<Cast> starCast = new ArrayList<>();
		starCast.add(new Cast(defaultBiopicMovie.getActor(), "Actor"));
		starCast.add(new Cast(defaultBiopicMovie.getActoress(), "Actoress"));
		return ResponseEntity.ok()
				.body(new MovieResource(defaultBiopicMovie.getId(), defaultBiopicMovie.getName(), starCast, null, null,
						null, defaultBiopicMovie.getReleaseDate(), defaultBiopicMovie.getBudget(),
						defaultBiopicMovie.getGrossIncome(), defaultBiopicMovie.getVerdict(),
						defaultBiopicMovie.getStarRating()));

	}

	@GetMapping("/movies/default/songs/default")
	public ResponseEntity<Song> getDefaultSongOfDefaultMovie() {
		return songsServiceClient.getDefaultSong("Javed Akhtar", "Sonu nigam");

	}

	@GetMapping("/movies/default/songs/default/rest")
	public ResponseEntity<Song> postDefaultSongOfDefaultMovieRest(HttpServletRequest request) {

		logger.info("Request URI is {}", request.getRequestURI());
		logger.info("Going to call songs service url to get default song .");
		ResponseEntity<Song> song = restTemplate.getForEntity("http://songs-service/songs/default", Song.class);
		logger.info("Returning default song data as {} ", song.getBody());
		return song;

	}

	@PostMapping("/movies/default/songs/default/rest")
	public ResponseEntity<Song> postDefaultSongOfDefaultMovieRest(@RequestBody(required = false) Song song) {
		return restTemplate.postForEntity("http://songs-service/songs", song, Song.class);

	}

	@PutMapping("/movies/default/songs/default/rest")
	public void putDefaultSongOfDefaultMovieRest(@RequestBody(required = false) Song song) {
		restTemplate.put("http://songs-service/songs", song);

	}

}
