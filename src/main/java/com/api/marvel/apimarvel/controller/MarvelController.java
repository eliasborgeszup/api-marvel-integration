package com.api.marvel.apimarvel.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.marvel.apimarvel.controller.marvel.response.MarvelResponse;
import com.api.marvel.apimarvel.service.impl.MarvelServiceImpl;

@RestController
@RequestMapping(value = "/marvel")
public class MarvelController {

	MarvelServiceImpl service;

	public MarvelController(MarvelServiceImpl service) {
		this.service = service;
	}

	@ResponseStatus(OK)
	@GetMapping()
	public List<MarvelResponse> findAll() {
		return service.findAll();
	}
}
