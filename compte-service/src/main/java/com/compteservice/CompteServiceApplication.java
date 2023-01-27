package com.compteservice;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.compteservice.entities.Compte;
import com.compteservice.enums.TypeCompte;
import com.compteservice.repositories.CompteRepo;



@SpringBootApplication
public class CompteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteServiceApplication.class, args);
	}
	
	
	
	@Bean
	CommandLineRunner start(CompteRepo compteRepo, RepositoryRestConfiguration restConfiguration) {
		return argz->{
			restConfiguration.exposeIdsFor(Compte.class);
			compteRepo.save(new Compte(null,90000,new Date(),TypeCompte.COURANT));
			compteRepo.save(new Compte(null,30000,new Date(),TypeCompte.EPARGNE));
			compteRepo.save(new Compte(null,123000,new Date(),TypeCompte.COURANT));
			compteRepo.findAll().forEach(s->{
				System.out.println(s.getSolde());
				System.out.println(s.getType());

			});
		};
	}
	
	
}
