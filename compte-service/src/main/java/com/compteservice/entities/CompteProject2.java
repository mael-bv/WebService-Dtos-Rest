package com.compteservice.entities;

import org.springframework.data.rest.core.config.Projection;

import com.compteservice.enums.TypeCompte;

@Projection(name="p2", types = Compte.class)
public interface CompteProject2 {
	public double getSolde();
	public TypeCompte getType();
}