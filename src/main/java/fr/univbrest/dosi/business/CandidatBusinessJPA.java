package fr.univbrest.dosi.business;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;


@Component
public class CandidatBusinessJPA implements CandidatBusiness{

    CandidatRepository repos;

	
    @Autowired
    public CandidatBusinessJPA(CandidatRepository repos) { 
    	this.repos=repos;
    }
	
	@Override
	public Candidat creerCandidat(Candidat candidatACreer) {
		
		candidatACreer.setEmail("email");
		candidatACreer.setAdresse("Adresse");
		   return repos.save(candidatACreer);
	}

	@Override
	public void supprimerCandidat(String id) {

		repos.delete(repos.findByNoCandidat(id));
		
	}

	@Override
	public List<Candidat> findCandidatByNom(String nom) {

		List<Candidat> canditatRecherche= repos.findByNom(nom);
		return canditatRecherche;
		
	}

	@Override
	public List<Candidat> findCandidatByUniversiteOrigine(String universiteOrigine) {
		List<Candidat> canditatRecherche= repos.findByUniversiteOrigine(universiteOrigine);		
		return canditatRecherche;
	}

	@Override
	public List<Candidat> recupererTousLesCandidats() {
		return (List<Candidat>) repos.findAll();
	}

	@Override
	public List<Candidat> recupererLeCandidatAvecLeNom(String nom) {
	
		return repos.findByNom(nom);
	}

	@Override
	public List<Candidat> recupererLeCandidatAvecId(String id) {
		return repos.findByNoCandidat(id);
	}

	@Override
	public List<Candidat> recupererLeCandidatAvecUnivOrigine(String universiteOrigine) {
		return repos.findByUniversiteOrigine(universiteOrigine);
	}

	
	
	
	

}
