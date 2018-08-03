package com.katariasoft.microservices.movieservice.web.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katariasoft.microservices.movieservice.web.soap.config.flight.FlightWebServiceConfiguration;
import com.katariasoft.microservices.movieservice.web.soap.config.hotel.HotelWebServiceConfiguration;

@RestController
public class SoapServicesConfiurarionProviderService {

	@Autowired
	private FlightWebServiceConfiguration flight;
	@Autowired
	private HotelWebServiceConfiguration hotel;

	@GetMapping("/configurations/soapservices/flights")
	public ResponseEntity<String> getFlightConfiguration() {
		return ResponseEntity.ok()
				.body(flight.getFetchDummyResponse() + " " + flight.getFileName() + " " + flight.getRootNode() + " "
						+ flight.getJaxbPackage() + " " + flight.getSoapActionHeaderUri() + " " + flight.getUri());
	}

	@GetMapping("/configurations/soapservices/hotels")
	public ResponseEntity<String> getHotelConfiguration() {
		return ResponseEntity.ok()
				.body(hotel.getFetchDummyResponse() + " " + hotel.getFileName() + " " + hotel.getRootNode() + " "
						+ hotel.getJaxbPackage() + " " + hotel.getSoapActionHeaderUri() + " " + hotel.getUri());
	}

}
