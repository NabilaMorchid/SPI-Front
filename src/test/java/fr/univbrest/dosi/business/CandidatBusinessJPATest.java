package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;


public class CandidatBusinessJPATest {

	CandidatBusinessJPA business;

	@Test
	public void doitCreerUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidatACreer = new Candidat("3312","nom1", "prenom1","univLyon");
		Candidat resultat = business.creerCandidat(candidatACreer);

		assertThat(resultat.getAdresse()).isEqualTo("Adresse");
		assertThat(resultat.getNom()).isEqualTo("nom1");
		
	}
	
	
	@Test
	public void doitRechercherUnCandidatParNom() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidat = new Candidat("3312","nom1", "prenom1","univLyon");
		business.repos.save(candidat);
		List<Candidat> resultat =  business.findCandidatByNom("nom1");
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("univLyon");	
	}

		
	@Test
	public void doitSupprimerCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidatASupprimer = new Candidat("3312","nom1", "prenom1","univLyon" );
		business.supprimerCandidat(candidatASupprimer.getNoCandidat());
		assertThat(repos.count()).isEqualTo(0);
		
	}

	public class CandidatRepositoryList implements CandidatRepository{

		 private List<Candidat> data;

		 public CandidatRepositoryList(Candidat... candidat) {
			 data=Lists.newArrayList(candidat);
			 }

				 
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void delete(String candidat) {
			// TODO Auto-generated method stub
			data.remove(candidat);
		}

		@Override
		public void delete(Candidat arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Iterable<? extends Candidat> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Candidat> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Candidat> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Candidat findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> S save(S entity) {
			data.add(entity);
			 return entity;
		}

		@Override
		public <S extends Candidat> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> findByNom(String nom) {
			 List<Candidat> listeCandidat = new ArrayList<>();
				for(Candidat c : data) {
					if(c.getNom()==nom) {
						listeCandidat.add(c);										
					}
				}
				return listeCandidat;
		}

		@Override
		public List<Candidat> findByPrenom(String prenom) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public List<Candidat> findByNoCandidat(String noCandidat) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
}
