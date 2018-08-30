package com.katariasoft.microservices.songsservice.web.songs.controller;

import javax.ws.rs.HeaderParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	private static final Logger logger = LoggerFactory.getLogger(SongsController.class);

	@GetMapping(path = "/songs/default", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Song> getDefaultSong(@RequestParam(name = "singer", required = false) String singer,
			@RequestParam(name = "lyricist", required = false) String lyricist) {
		logger.info("In getDefaultSong method of songs-service");
		logger.info("Request param singer is {}", singer);
		logger.info("Request param lyricist is {}", lyricist);
		ResponseEntity<Song> song = ResponseEntity.ok().body(new Song(defaultSong.getName(), defaultSong.getRating(),
				defaultSong.getLyrics(), port, singer, lyricist));
		logger.info("Returning song bean as {} ", song.getBody().toString());
		return song;

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
