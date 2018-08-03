package com.katariasoft.microservices.movieservice.web.soap.config.hotel;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.katariasoft.microservices.movieservice.web.soap.config.WebServiceConfigurationTemplate;

@Configuration
@PropertySource("classpath:/properties/soap/${environment}/HotelService.properties")
public class HotelWebServiceConfiguration extends WebServiceConfigurationTemplate {

	@Autowired
	private Environment environment;

	@PostConstruct
	public void initProperties() {
		rootNode = environment.getProperty("hotelwebservice.rootNode");
		jaxbPackage = environment.getProperty("hotelwebservice.jaxbPackage");
		uri = environment.getProperty("hotelwebservice.uri");
		fetchDummyResponse = environment.getProperty("hotelwebservice.fetchDummyResponse");
		fileName = environment.getProperty("hotelwebservice.fileName");
		logXml = Boolean.parseBoolean(environment.getProperty("hotelwebservice.logXml"));
		soapActionHeaderUri = environment.getProperty("hotelwebservice.soapActionHeaderUri");
	}

}
