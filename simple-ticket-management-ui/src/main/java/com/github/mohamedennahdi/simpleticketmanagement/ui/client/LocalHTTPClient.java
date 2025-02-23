package com.github.mohamedennahdi.simpleticketmanagement.ui.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class LocalHTTPClient {

	private Properties properties = new Properties();

	public LocalHTTPClient() {
		try (InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties")) {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResponseEntity<String> invoke(String endpoint, HttpMethod httpMethod, Map<String, String> requestParams,
			Map<String, Object> pathVaribles) {
		String url = properties.getProperty("simple.ticket.management.backend");

		RestTemplate restTemplate = new RestTemplate();
		url = url + endpoint;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

		for (Map.Entry<String, String> entry : requestParams.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), httpMethod, entity, String.class, pathVaribles);

		return response;
	}
}
