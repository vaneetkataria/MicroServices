package com.katariasoft.microservices.movieservice.web.movie.beans;

public class Song {

	private String name;
	private String rating;
	private String lyrics;
	private String port;
	private String singer;
	private String lyricist;

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

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	@Override
	public String toString() {
		return "Song [name=" + name + ", rating=" + rating + ", lyrics=" + lyrics + ", port=" + port + ", singer="
				+ singer + ", lyricist=" + lyricist + "]";
	}

}
