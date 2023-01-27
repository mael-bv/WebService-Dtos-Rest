package com.compteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compteservice.entities.Compte;
import com.compteservice.repositories.CompteRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompteServiceImpl implements CompteService{
	@Autowired
	private CompteRepo compteRepo;
	@Override
	public void virement(Long idGive, Long idTake, double montant) {
		Compte cust1 =  compteRepo.findById(idGive).get();
		Compte cust2 =  compteRepo.findById(idTake).get();
		cust1.setSolde(cust1.getSolde()-montant);
		cust2.setSolde(cust2.getSolde()+montant);
		compteRepo.save(cust1);
		compteRepo.save(cust2);
	}

}
