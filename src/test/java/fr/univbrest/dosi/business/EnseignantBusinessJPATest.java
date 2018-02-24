package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;


public class EnseignantBusinessJPATest {

	EnseignantBusinessJPA business;
	

	
	@Test
	public void doitCreerUnEnseignant() {
	
	EnseignantRepository repos = new EnseignantRepositoryList();
	business = new EnseignantBusinessJPA(repos);
	Enseignant enseignantACreer =  new Enseignant("adresse1", "20200", "nom1", "ville1");
	Enseignant resultat = business.creerEnseignant(enseignantACreer);
	assertThat(resultat.getTelephone()).isEqualTo("telephone");
	assertThat(repos.count()).isEqualTo(1);
}
	
	@Test
	public void doitRechercherToutesLesEnseignants() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant1 = new Enseignant("adresse1", "20200", "nom1", "ville1");
		Enseignant enseignant2 = new Enseignant("adresse2", "20400", "nom2", "ville2");
		business.repos.save(enseignant1);
		business.repos.save(enseignant2);
		assertThat(repos.count()).isEqualTo(2);
		}
		
	@Test
	public void doitRechercherUnEnseignantParNom() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant = new Enseignant("adresse1", "20200", "nom1", "ville1");
		business.repos.save(enseignant);
		Enseignant resultat =  business.findEnseignantByNom("nom1");
		assertThat(resultat.getVille()).isEqualTo("ville1");	
	}

	
	 @Test
	public void doitRechercherUnEnseignantParNoEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant = new Enseignant(2354, "adress", "25588", "email","nom");
		repos.save(enseignant);
		Enseignant resultat =  business.findEnseignantByNoEnseignant(2354);
		assertThat(resultat.getNoEnseignant()).isEqualTo(2354);	
	}
	 
	 @Test
		public void doitRechercherUnEnseignantParType() {
			EnseignantRepository repos = new EnseignantRepositoryList();
			business = new EnseignantBusinessJPA(repos);
			Enseignant enseignant = new Enseignant(988, "20200", "nom1", "rc");
			business.repos.save(enseignant);
			List<Enseignant> resultat =  business.findEnseignantByType("rc");
			assertThat(resultat.get(0).getType()).isEqualTo("rc");	
		}

	
	@Test
	public void doitSupprimerEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant enseignantASupprimer = new Enseignant("adresse1", "20200", "nom1", "ville1");
		business.supprimerEnseignant(enseignantASupprimer.getNoEnseignant());
		assertThat(repos.count()).isEqualTo(0);
		
	}
	
	
	
	public class EnseignantRepositoryList implements EnseignantRepository{

		private List<Enseignant> data;

		 public EnseignantRepositoryList(Enseignant... enseignant) {
			 data=Lists.newArrayList(enseignant);
			 }

		@Override
		public <S extends Enseignant> S save(S entity) {
			data.add(entity);
			 return entity;
		}

		@Override
		public <S extends Enseignant> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Enseignant findOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Enseignant> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Enseignant> findAll(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public void delete(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Enseignant entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Iterable<? extends Enseignant> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Enseignant findByNom(String nom) {
			Enseignant lis = new Enseignant();
			for (Enseignant e : data) {
				if(e.getNom()==nom) {
					lis=e;
				}
			}
			return lis;
		}

		@Override
		public Enseignant findBynoEnseignant(long noEnseignant) {
			
			Enseignant ens = new Enseignant();
			for(Enseignant e : data) {
				if(e.getNoEnseignant()==noEnseignant) {
					ens=e;
				}
			}
			return ens;
		}

		@Override
		public List<Enseignant> findEnseignantByType(String type) {
			List<Enseignant> ens = new ArrayList<>();
			for(Enseignant e : data) {
				if(e.getType().equals(type)) {
					ens.add(e);
				}
			}
			return ens;
		}		
		
	}
}