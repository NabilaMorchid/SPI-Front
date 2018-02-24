package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class CandidatRepositoryTest {
	
	@Autowired 
	CandidatRepository candidatRepo;
	
	@Before
	public void setup() {
		
		
		Candidat candidat1 = new Candidat("3312","nom1", "prenom1","univLyon");
		Candidat candidat2 = new Candidat("2955", "nom2", "prenom2","univParis");
	
		candidatRepo.save(candidat1);
		candidatRepo.save(candidat2);
	}

	
	@Test
	public void doitCompterLesCandidats() {
		long resultat = candidatRepo.count();
		
		assertThat(resultat).isEqualTo(2);
	}
	
	@Test
	public void doitRechercherParNom() {
		List<Candidat> res = candidatRepo.findByNom("nom1");
		
		assertThat(res).hasSize(1);
		assertThat(res.get(0).getNom()).isEqualTo("nom1");
		assertThat(res.get(0).getNoCandidat()).isEqualTo("3312");
	}
	
	@Test
	public void doitRechercherParPrenom() {
		List<Candidat> res = candidatRepo.findByPrenom("prenom1");
		
		assertThat(res).hasSize(1);
		assertThat(res.get(0).getPrenom()).isEqualTo("prenom1");
		assertThat(res.get(0).getNoCandidat()).isEqualTo("3312");
	}
	
	
	@Test
	public void doitRechercherParUniversiteOrigine() {
		List<Candidat> res = candidatRepo.findByUniversiteOrigine("univLyon");
		
		assertThat(res).hasSize(1);
		assertThat(res.get(0).getUniversiteOrigine()).isEqualTo("univLyon");
		assertThat(res.get(0).getNoCandidat()).isEqualTo("3312");
	}
	
}
