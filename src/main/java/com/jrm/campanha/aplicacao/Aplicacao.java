package com.jrm.campanha.aplicacao;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Aplicacao {

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/campanhas")).build();
		
		ResponseEntity<Campanha[]> response = restTemplate.exchange(request, Campanha[].class);
		
		for(Campanha campaha : response.getBody()) {
			System.out.println("Campanha: " + campaha.getNome());
		}
	}
}
