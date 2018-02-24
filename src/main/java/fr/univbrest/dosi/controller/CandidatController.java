package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;

@RestController
@RequestMapping("/candidat")
public class CandidatController {

	private CandidatBusiness business;

	@Autowired
	public CandidatController(CandidatBusiness business) {
		super();
		this.business = business;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Candidat creerCandidat(@RequestBody Candidat candidatACreer) {
		return business.creerCandidat(candidatACreer);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Candidat> recupererTousLesCandidats(){
		
		return business.recupererTousLesCandidats();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/nom/{nom}")
	public List<Candidat> recupererLeCandidatAvecLeNom(@PathVariable String nom){
		return business.recupererLeCandidatAvecLeNom(nom);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/univOrigine/{univOrigine}")
	public List<Candidat> recupererLeCandidatAvecUnivOrigine(@PathVariable String univOrigine){
		return business.recupererLeCandidatAvecUnivOrigine(univOrigine);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public List<Candidat> recupererLeCandidatAvecId(@PathVariable String id){
		return business.recupererLeCandidatAvecId(id);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/suppr/{id}")
	public void supprimerCandidat(@PathVariable String id) {    
		
		business.supprimerCandidat(id);
		
	}
	
	
	
}
