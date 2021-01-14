package com.api.marvel.apimarvel.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.marvel.apimarvel.controller.marvel.response.MarvelResponse;

@Service
public class MarvelServiceImpl {
	@Value("${url.postmon}")
	private String uri;
	
	public MarvelResponse findAll() {
		RestTemplate restTemplate = new RestTemplate();
		
		//ResponseEntity<MarvelResponse[]> responseEntity = restTemplate.getForObject(uri, MarvelResponse[].class);
		
	
		return restTemplate.getForObject(uri, MarvelResponse.class);
	
	}
}
