package com.jrm.campanha.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.jrm.campanha.aplicacao.client.CampanhasClient;
import com.jrm.campanha.aplicacao.client.TimesClient;
import com.jrm.campanha.aplicacao.client.domain.Campanha;
import com.jrm.campanha.aplicacao.client.domain.TimeCoracao;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		
		CampanhasClient campanhasClient = new CampanhasClient();
		TimesClient timesClient = new TimesClient();
		
		List<Campanha> listaCampanhas = campanhasClient.listar();
		
		for(Campanha campaha : listaCampanhas) {
			System.out.println("Campanha: " + campaha.getNome());
		}
		
		Campanha campanha = new Campanha();
		campanha.setNome("Campeonato Brasileiro");
		
		SimpleDateFormat vigencia = new SimpleDateFormat("dd/MM/yyyy");
		campanha.setInicioVigencia(vigencia.parse("15/01/2018"));
		campanha.setFimVigencia(vigencia.parse("16/01/2018"));
		
		TimeCoracao timeCoracao = new TimeCoracao();
		timeCoracao.setNome("SC Corinthians Paulista");
		timeCoracao.setNacionalidade("Brasil");
				
		campanha.setTimeCoracao(timesClient.salvar(timeCoracao));
		
		String localizacao = campanhasClient.salvar(campanha);
		
		System.out.println("URI da camapanha salva: " + localizacao);
	}
}
