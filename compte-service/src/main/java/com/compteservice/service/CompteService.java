package com.compteservice.service;

public interface CompteService {
	
	void virement(Long idGive,Long idTake, double montant);

}
