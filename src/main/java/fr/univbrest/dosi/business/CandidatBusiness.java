package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Candidat;

public interface CandidatBusiness {

	Candidat creerCandidat(Candidat candidatACreer);
	
	void supprimerCandidat(String id);
	List<Candidat> findCandidatByNom(String nom);
	List<Candidat> findCandidatByUniversiteOrigine(String universiteOrigine);

	List<Candidat> recupererTousLesCandidats();

	List<Candidat> recupererLeCandidatAvecLeNom(String nom);

	List<Candidat> recupererLeCandidatAvecId(String id);

	List<Candidat> recupererLeCandidatAvecUnivOrigine(String univOrigine);
}
