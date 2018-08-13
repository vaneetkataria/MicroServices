package com.katariasoft.microservices.movieservice.web.movie.helper.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.katariasoft.microservices.movieservice.web.movie.beans.Song;

@FeignClient(value = "songs-service")
@RibbonClient(value = "songs-service")
public interface SongsServiceClient {

	@GetMapping(path = "/songs/default", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Song> getDefaultSong();

}
