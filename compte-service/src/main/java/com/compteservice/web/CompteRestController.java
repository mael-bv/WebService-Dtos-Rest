package com.compteservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.compteservice.entities.Compte;
import com.compteservice.repositories.CompteRepo;
import com.compteservice.service.CompteService;

//@RestController
public class CompteRestController {
	
@Autowired	
private CompteRepo compteRepo;
@Autowired
private CompteService compteService;

	public CompteRestController(CompteRepo compteRepo) {
		this.compteRepo = compteRepo;
	}
	
	@GetMapping("/comptes")
	public List<Compte> listComptes(){
		return compteRepo.findAll();
	}
	
	@GetMapping("/compte/{id}")
	public Compte findCompte(@PathVariable(name = "id") Long id) {
		return compteRepo.findById(id).get();
	}
	
	@PostMapping("/save")
	public Compte addCompte(@RequestBody Compte compte) {
		return compteRepo.save(compte);
	}
	
	@PutMapping("/update/{id}")
	public Compte updateCompte(@PathVariable(name = "id") Long id, @RequestBody Compte compte) {
		compte.setId(id);
		return compteRepo.save(compte);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		compteRepo.deleteById(id);
	}
	
	
}


