package com.jrm.campanha.aplicacao.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jrm.campanha.aplicacao.client.domain.TimeCoracao;

public class TimesClient {
	
	public List<TimeCoracao> listar() {
		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/times")).build();

		ResponseEntity<TimeCoracao[]> response = restTemplate.exchange(request, TimeCoracao[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public TimeCoracao salvar(TimeCoracao timeCoracao) {
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<TimeCoracao> request = RequestEntity
				.post(URI.create("http://localhost:8080/times"))
				.body(timeCoracao);
		
		ResponseEntity<TimeCoracao> response = restTemplate.exchange(request, TimeCoracao.class);
		
		return response.getBody();
	}

}
