package com.jrm.campanha.aplicacao.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jrm.campanha.aplicacao.client.domain.Campanha;

public class CampanhasClient {

	public List<Campanha> listar() {
		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/campanhas")).build();

		ResponseEntity<Campanha[]> response = restTemplate.exchange(request, Campanha[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String salvar(Campanha campanha) {
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Campanha> request = RequestEntity
				.post(URI.create("http://localhost:8080/campanhas"))
				.body(campanha);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
}
