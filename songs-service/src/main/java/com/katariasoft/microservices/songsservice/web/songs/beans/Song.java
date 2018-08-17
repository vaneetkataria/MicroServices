package com.katariasoft.microservices.songsservice.web.songs.beans;

public class Song {

	private String name;
	private String rating;
	private String lyrics;
	private String port;
	private String lyricist;
	private String singer;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(String name, String rating, String lyrics, String port, String singer, String lyricist) {
		super();
		this.name = name;
		this.rating = rating;
		this.lyrics = lyrics;
		this.port = port;
		this.singer = singer;
		this.lyricist = lyricist;
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

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

}
