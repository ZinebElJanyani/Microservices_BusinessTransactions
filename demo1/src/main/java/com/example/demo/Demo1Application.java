package com.example.demo;

import com.example.demo.dao.EntrepriseRepository;
import com.example.demo.entities.Entreprise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	CommandLineRunner start(EntrepriseRepository entrepriseRepository){
		return args -> {
			Stream.of("A","B","C").forEach(c -> entrepriseRepository.save(new Entreprise(null,c,100+Math.random()*900)));
			entrepriseRepository.findAll().forEach(System.out::println);
		};
	}
}
