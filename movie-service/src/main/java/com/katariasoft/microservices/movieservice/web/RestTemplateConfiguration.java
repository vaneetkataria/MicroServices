package com.dhisco.product.automation.core.config.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingInterceptor.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
	return restTemplateBuilder.additionalInterceptors(new RequestResponseLoggingInterceptor())
		.requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
		.build();
    }

    private class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
		throws IOException {
	    logRequest(request, body);
	    ClientHttpResponse response = execution.execute(request, body);
	    logResponse(response);
	    return response;
	}

	private void logRequest(HttpRequest request, byte[] body) throws IOException {
	    if (logger.isDebugEnabled()) {
		logger.debug(
			"===========================request begin================================================");
		logger.debug("URI         : {}", request.getURI());
		logger.debug("Method      : {}", request.getMethod());
		logger.debug("Headers     : {}", request.getHeaders());
		logger.debug("Request body: {}", new String(body, "UTF-8"));
		logger.debug("==========================request end================================================");
	    }
	}

	private void logResponse(ClientHttpResponse response) throws IOException {
	    if (logger.isDebugEnabled()) {
		logger.debug("============================response begin==========================================");
		logger.debug("Status code  : {}", response.getStatusCode());
		logger.debug("Status text  : {}", response.getStatusText());
		logger.debug("Headers      : {}", response.getHeaders());
		logger.debug("Response body: {}", StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8));
		logger.debug("=======================response end=================================================");
	    }
	}
    }

}
