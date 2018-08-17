package com.katariasoft.microservices.songsservice.web.songs.controller;

import javax.ws.rs.HeaderParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.katariasoft.microservices.songsservice.web.songs.beans.DefaultSong;
import com.katariasoft.microservices.songsservice.web.songs.beans.Song;

@RestController
public class SongsController {

	@Autowired
	private DefaultSong defaultSong;

	@Value("${server.port}")
	private String port;

	@GetMapping(path = "/songs/default", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Song> getDefaultSong(@RequestParam(name = "singer", required = false) String singer,
			@RequestParam(name = "lyricist", required = false) String lyricist) {
		return ResponseEntity.ok().body(new Song(defaultSong.getName(), defaultSong.getRating(),
				defaultSong.getLyrics(), port, singer, lyricist));

	}

	@PostMapping(path = "/songs", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Song> addSong(@RequestParam(name = "singer", required = false) String singer,
			@RequestParam(name = "lyricist", required = false) String lyricist,
			@HeaderParam(value = "showParams") boolean showParams, @RequestBody(required = false) Song song) {
		song.setPort(port);
		return ResponseEntity.ok().body(song);
	}

	@PutMapping(path = "/songs", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Song> putSong(@RequestParam(name = "singer", required = false) String singer,
			@RequestParam(name = "lyricist", required = false) String lyricist,
			@HeaderParam(value = "showParams") boolean showParams, @RequestBody(required = false) Song song) {
		song.setPort(port);
		return ResponseEntity.ok().body(song);
	}

}
