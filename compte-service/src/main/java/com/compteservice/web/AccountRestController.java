package com.compteservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.compteservice.dtos.VirementRequestDto;
import com.compteservice.entities.Compte;
import com.compteservice.service.CompteService;

@RestController
public class AccountRestController {
	@Autowired
	private CompteService compteService;
	
	
	
	/*
	 * @PutMapping(path = "/virement") public void transfer(@RequestBody
	 * VirementRequestDto request) {
	 * compteService.virement(request.getIdGive(),request.getIdTake(),request.
	 * getMontant()); }
	 */
	
	@PutMapping(path = "/virement")
	public void virement(@RequestBody Compte compte) {
		compteService.virement(compte.getId(), compte.getId(), compte.getSolde());
	}

}
