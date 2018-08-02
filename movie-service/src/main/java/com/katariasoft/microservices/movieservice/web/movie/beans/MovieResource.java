package com.katariasoft.microservices.movieservice.web.movie.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MovieResource {

	private int id;
	private String name;
	private List<Cast> starCast;
	private List<Cast> directors;
	private List<Cast> producers;
	private List<Cast> musicDirectors;
	private String releaseDate;
	private String budget;
	private String grossIncome;
	private String verdict;
	private String starRating;

	public MovieResource(int id, String name, List<Cast> starCast, List<Cast> directors, List<Cast> producers,
			List<Cast> musicDirectors, String releaseDate, String budget, String grossIncome, String verdict,
			String starRating) {
		super();
		this.id = id;
		this.name = name;
		this.starCast = starCast;
		this.directors = directors;
		this.producers = producers;
		this.musicDirectors = musicDirectors;
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

	public List<Cast> getStarCast() {
		return starCast;
	}

	public void setStarCast(List<Cast> starCast) {
		this.starCast = starCast;
	}

	public List<Cast> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Cast> directors) {
		this.directors = directors;
	}

	public List<Cast> getProducers() {
		return producers;
	}

	public void setProducers(List<Cast> producers) {
		this.producers = producers;
	}

	public List<Cast> getMusicDirectors() {
		return musicDirectors;
	}

	public void setMusicDirectors(List<Cast> musicDirectors) {
		this.musicDirectors = musicDirectors;
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

}
