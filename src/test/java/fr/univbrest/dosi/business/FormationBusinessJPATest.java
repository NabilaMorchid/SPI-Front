package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;
import static org.assertj.core.api.Assertions.assertThat;

public class FormationBusinessJPATest {

	FormationBusinessJPA business;

	@Test
	public void doitCreerUneFormation() {
		FormationRepository repos = new FormationRepositoryList();
		business = new FormationBusinessJPA(repos);
		Formation formationACreer = new Formation("33", "M2", "O", BigDecimal.valueOf(2.0), "DOSI");
		Formation resultat = business.creerFormation(formationACreer);

		assertThat(resultat.getDebutAccreditation()).isCloseTo(new Date() ,500);
		assertThat(repos.count()).isEqualTo(1);
	
	}
	
	
	@Test
	public void doitSupprimerFormation() {
		FormationRepository repos = new FormationRepositoryList();
		business = new FormationBusinessJPA(repos);
		Formation formationASupprimer = new Formation("33", "M2", "O", BigDecimal.valueOf(2.0), "DOSI");;
		business.supprimerFormation(formationASupprimer.getCodeFormation());
		assertThat(repos.count()).isEqualTo(0);
		
	}


	class FormationRepositoryList implements FormationRepository{
   
	 private List<Formation> data;

	 public FormationRepositoryList() {
		 data=Lists.newArrayList();
		 }

	 @Override
		public <S extends Formation> S save(S entity) {
		 data.add(entity);
		 return entity;
		}

	@Override
	public long count() {
		
		return data.size();
	}

	@Override
	public void delete(String arg0) {
		
	}

	@Override
	public void delete(Formation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Formation> arg0) {
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
	public Iterable<Formation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Formation> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public <S extends Formation> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Formation> findByNomFormation(String nomFormation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation findByCodeFormation(String codeFormation) {
		Formation form = new Formation();
		for(Formation f : data) {
			if(f.getCodeFormation()==codeFormation) {
				form=f;
			}
		}
		return form;
	}

}}					