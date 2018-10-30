package com.example.demo;

import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Fabricante;
import com.example.demo.domain.FabricanteRepository;
import com.example.demo.domain.Modelo;
import com.example.demo.domain.ModeloRepository;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args).close();
	}
	
	@Bean
	CommandLineRunner run(FabricanteRepository repFabricante, ModeloRepository repModelo) {
		return evt -> {
			
			Fabricante fab1 = repFabricante.save(new Fabricante(null, "Fabricante1", null));
			Fabricante fab2 = repFabricante.save(new Fabricante(null, "Fabricante2", null));
			
			repModelo.save(new Modelo(null, "modelo_1", "2010", fab1));
			System.out.println(repModelo.findAll());
			
			repModelo.save(new Modelo(null, "modelo_2", "2011", fab2));
			System.out.println(repModelo.findAll());
			
			System.out.println("2010 :: " + repFabricante.findByModelosAno("2010").stream().map(Fabricante::getName).collect(Collectors.toList()));
			System.out.println("2011 :: " + repFabricante.findByModelosAno("2011").stream().map(Fabricante::getName).collect(Collectors.toList()));
		};
	}
}
