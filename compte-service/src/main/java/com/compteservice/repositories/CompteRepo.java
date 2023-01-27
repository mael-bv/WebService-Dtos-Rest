package com.compteservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.compteservice.entities.Compte;
import com.compteservice.enums.TypeCompte;

@RepositoryRestResource
public interface CompteRepo extends JpaRepository<Compte, Long> {
	
	@RestResource(path = "/byType")
	List<Compte> findByType(@Param(value = "type") TypeCompte typeCompte);

}
