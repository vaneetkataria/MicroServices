package com.katariasoft.microservices.songsservice.web.songs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katariasoft.microservices.songsservice.web.songs.beans.DefaultSong;
import com.katariasoft.microservices.songsservice.web.songs.beans.Song;

@RestController
public class SongsController {

	@Autowired
	private DefaultSong defaultSong;

	@GetMapping(path = "/songs/default", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Song> getDefaultSong() {
		return ResponseEntity.ok()
				.body(new Song(defaultSong.getName(), defaultSong.getRating(), defaultSong.getLyrics()));

	}

}
