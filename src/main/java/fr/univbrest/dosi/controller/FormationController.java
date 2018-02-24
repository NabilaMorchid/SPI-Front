package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;

@RestController
@RequestMapping("/formation")
public class FormationController {
	
	private FormationBusiness business;
	
	@Autowired
	public FormationController(FormationBusiness business) {
		this.business= business;}
		
	
	@RequestMapping(method=RequestMethod.POST)
	public Formation creerFormation(@RequestBody Formation formationACreer) { 
		return business.creerFormation(formationACreer);
	}
	
	public FormationController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@RequestMapping(method=RequestMethod.GET)
	public List<Formation> recupererToutesLesFormations(){
		
		return business.recupererToutesLesFormations();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/count")
	public long recupererNombreFormations(){
		
		return business.recupererCount();
	}

	@RequestMapping(method=RequestMethod.GET, value="/nom/{nom}")
	public List<Formation> recupererLaFormationAvecLeNom(@PathVariable String nom){
		return business.recupererLaFormationAvecLeNom(nom);
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Formation recupererLaFormationAvecLeId(@PathVariable String id){
		return business.recupererLaFormationAvecId(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/suppr/{codeFormation}")
	public void supprimerFormation(@PathVariable String codeFormation) {    
		
		business.supprimerFormation(codeFormation);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Formation modifierFormation(@RequestBody Formation formationAMaj) {
		return business.modifierFormation(formationAMaj);
	}
	
}
