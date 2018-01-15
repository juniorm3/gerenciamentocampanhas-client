package com.jrm.campanha.aplicacao.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jrm.campanha.aplicacao.client.domain.Campanha;

public class CampanhasClient {
	
	private RestTemplate restTemplate;
	
	private String URI_BASE;
	
	private String URN_BASE = "/campanhas";
	
	public CampanhasClient(String url) {
		restTemplate = new RestTemplate();
		
		URI_BASE = url.concat(URN_BASE);
	}

	public List<Campanha> listar() {
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE)).build();

		ResponseEntity<Campanha[]> response = restTemplate.exchange(request, Campanha[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String salvar(Campanha campanha) {
		RequestEntity<Campanha> request = RequestEntity
				.post(URI.create(URI_BASE))
				.body(campanha);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
	
	public Campanha buscar(String uri) {
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uri)).build();
		
		ResponseEntity<Campanha> response = restTemplate.exchange(request, Campanha.class);
		
		return response.getBody();
	}
}
