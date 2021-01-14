package com.api.marvel.apimarvel.service.impl;

import java.security.MessageDigest;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.marvel.apimarvel.controller.marvel.response.MarvelResponse;

@Service
public class MarvelComicsServiceImpl {
	private static final java.lang.String PUBLIC_KEY = "de8ae6b7ddc90c4bbcaba79435515c1a";
	private static final java.lang.String PRIVATE_KEY = "36411abdd8d7167a1f98760edadb5189be6b339d";

	@Value("${url.postmon}/comics")
	private String url;

	public MarvelResponse findAll() {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(url + generatorParamUrl(), MarvelResponse.class);
	}

	public String generatorParamUrl() {
		Long ts = new Date().getTime();
		
		String fullParams = ts + PRIVATE_KEY + PUBLIC_KEY;
		String hashMd5 = null;

		try {			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(fullParams.getBytes());
			byte[] digest  = md.digest();
			
			 StringBuffer sb = new StringBuffer();
		     for (byte b : digest)
		    	 hashMd5 = sb.append(String.format("%02x", b & 0xff)).toString();			
			
			return "?ts=" + ts + "&apikey=" + PUBLIC_KEY + "&hash=" + hashMd5;
		} catch (java.security.NoSuchAlgorithmException e) {
			return e.getMessage();
		}

	}
}
