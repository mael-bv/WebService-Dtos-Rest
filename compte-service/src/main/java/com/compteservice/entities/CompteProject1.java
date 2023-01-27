package com.compteservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types = Compte.class)
public interface CompteProject1 {
	public Long getId();

}
