package com.katariasoft.microservices.movieservice.web.movie.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:properties/movie/action/defaultActionMovie_${environment}.properties")
public class EnvironmentAwareDefaultActionMovie {

	@Autowired
	private Environment environment;

	private Integer id;
	private String name;
	private String actor;
	private String actoress;
	private String releaseDate;
	@Value("${movie.action.default.budget}")
	private String budget;
	@Value("${movie.action.default.grossIncome}")
	private String grossIncome;
	@Value("${movie.action.default.verdict}")
	private String verdict;
	@Value("${movie.action.default.starRating}")
	private String starRating;
	private List<String> directors;

	public EnvironmentAwareDefaultActionMovie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initProperties() {
		id = Integer.parseInt(environment.getProperty("movie.action.default.id"));
		name = environment.getProperty("movie.action.default.name");
		actor = environment.getProperty("movie.action.default.actor");
		actoress = environment.getProperty("movie.action.default.actress");

	}

	public EnvironmentAwareDefaultActionMovie(int id, String name, String actor, String actoress, String releaseDate, String budget,
			String grossIncome, String verdict, String starRating) {
		super();
		this.id = id;
		this.name = name;
		this.actor = actor;
		this.actoress = actoress;
		this.releaseDate = releaseDate;
		this.budget = budget;
		this.grossIncome = grossIncome;
		this.verdict = verdict;
		this.starRating = starRating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getActoress() {
		return actoress;
	}

	public void setActoress(String actoress) {
		this.actoress = actoress;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getGrossIncome() {
		return grossIncome;
	}

	public void setGrossIncome(String grossIncome) {
		this.grossIncome = grossIncome;
	}

	public String getVerdict() {
		return verdict;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}

	public String getStarRating() {
		return starRating;
	}

	public void setStarRating(String starRating) {
		this.starRating = starRating;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

}
