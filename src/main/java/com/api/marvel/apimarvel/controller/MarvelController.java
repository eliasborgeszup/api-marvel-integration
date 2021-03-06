package com.api.marvel.apimarvel.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.marvel.apimarvel.controller.marvel.response.MarvelResponse;
import com.api.marvel.apimarvel.service.impl.MarvelComicsServiceImpl;

@RestController
@RequestMapping(value = "/marvel")
public class MarvelController {

	MarvelComicsServiceImpl service;

	public MarvelController(MarvelComicsServiceImpl service) {
		this.service = service;
	}

	@ResponseStatus(OK)
	@GetMapping(value = "/comics")
	public MarvelResponse findAll() {
		return service.findAll();
	}
}
