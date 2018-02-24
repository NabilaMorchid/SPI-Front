package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@RequestMapping("/enseignant")
public class EnseignantController {

	private EnseignantBusiness business ;

	@Autowired
	public EnseignantController(EnseignantBusiness business ) {
		this.business=business;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Enseignant creerEnseignant(@RequestBody Enseignant enseignantACreer) {
		return business.creerEnseignant(enseignantACreer);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Enseignant> recupererTousLesEnseignants(){
		
		return business.recupererTousLesEnseignants();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/count/")
	public long countEnseignant(){
		return business.countEnseignant();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/nom/{nom}")
	public Enseignant findEnseignantByNom(@PathVariable String nom){
		return business.findEnseignantByNom(nom);
	}
	@RequestMapping(method=RequestMethod.GET, value="/type/{type}")
	public List <Enseignant> findEnseignantByType(@PathVariable String type){
		return business.findEnseignantByType(type);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{noEnseignant}")
	public Enseignant findEnseignantByNoEnseignant(@PathVariable long noEnseignant){
		return business.findEnseignantByNoEnseignant(noEnseignant);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/suppr/{noEnseignant}")
	public void supprimerEnseignant(@PathVariable long noEnseignant) {    
		
		business.supprimerEnseignant(noEnseignant);
		
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Enseignant modifierEnseignant(@RequestBody Enseignant enseignantAMaj) {
		return business.modifierEnseignant(enseignantAMaj);
	}
	
	
		
}
