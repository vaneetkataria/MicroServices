package com.katariasoft.microservices.songsservice.web.songs.beans;

public class Song {

	private String name;
	private String rating;
	private String lyrics;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(String name, String rating, String lyrics) {
		super();
		this.name = name;
		this.rating = rating;
		this.lyrics = lyrics;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

}
