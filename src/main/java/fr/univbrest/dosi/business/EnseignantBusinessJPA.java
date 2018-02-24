package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@Component
public class EnseignantBusinessJPA implements EnseignantBusiness {

	EnseignantRepository repos;

	@Autowired
	public EnseignantBusinessJPA(EnseignantRepository repos) {

		this.repos = repos;
	}

	

	@Override
	public Enseignant creerEnseignant(Enseignant enseignantACreer) {

		enseignantACreer.setTelephone("telephone");
		enseignantACreer.setEmailUbo("emailUbo");

		return repos.save(enseignantACreer);
	}

	@Override
	public List<Enseignant> recupererTousLesEnseignants() {

		return (List<Enseignant>) repos.findAll();
	}

	@Override
	public Enseignant findEnseignantByNom(String nom) {

		return repos.findByNom(nom);

	}

	public void supprimerEnseignant(long noEnseignant) {
		repos.delete(findEnseignantById(noEnseignant));
	}

	private Enseignant findEnseignantById(long noEnseignant) {
		return repos.findBynoEnseignant(noEnseignant);
	}

	public Enseignant findEnseignantByNoEnseignant(long noEnseignant) {
		return repos.findBynoEnseignant(noEnseignant);
	}



	@Override
	public List <Enseignant> findEnseignantByType(String type) {
		
		return ( List <Enseignant> )repos.findEnseignantByType(type);
	}



	@Override
	public Enseignant modifierEnseignant(Enseignant enseignantAMaj) {
		
		return repos.save(enseignantAMaj);
	}



	@Override
	public long countEnseignant() {
		// TODO Auto-generated method stub
		return repos.count();
	}

}
