package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Candidat;

public interface CandidatRepository extends CrudRepository<Candidat, String> {
	List<Candidat> findByNom(String nom);
	List<Candidat> findByPrenom(String prenom);
	List<Candidat> findByUniversiteOrigine(String universiteOrigine);
	List<Candidat> findByNoCandidat(String noCandidat);
}
