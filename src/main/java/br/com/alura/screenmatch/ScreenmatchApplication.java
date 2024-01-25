package br.com.alura.screenmatch;

import br.com.alura.screenmatch.Model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPi = new ConsumoAPI();
		var json = consumoAPi.Obeterdados("https://www.omdbapi.com/?t=gilmore+girls&Season=1&apikey=e1048123");
		System.out.println(json);
		//json = consumoAPi.Obeterdados("https://coffee.alexflipnote.dev/random.json");
		//System.out.println(json);
		ConverteDados converteDados = new ConverteDados();
		DadosSerie dadosSerie = converteDados.obterdados(json, DadosSerie.class);
		System.out.println(dadosSerie);
	}
}
