package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantBusiness {
	
	
	Enseignant creerEnseignant(Enseignant enseignantACreer);

	Enseignant findEnseignantByNom(String nom);

	List<Enseignant> recupererTousLesEnseignants();

	Enseignant findEnseignantByNoEnseignant(long noEnseignant);

	void supprimerEnseignant(long noEnseignant);

	List<Enseignant> findEnseignantByType(String type);

	Enseignant modifierEnseignant(Enseignant enseignantAMaj);

	long countEnseignant();

}
