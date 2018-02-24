package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;

public class PromotionBusinessJPATest {

	PromotionBusinessJPA business;
	
	
	
	
	@Test
	public void doitCreerUnePromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		
		business = new PromotionBusinessJPA(repos);
		Promotion promotionACreer = new Promotion(new PromotionPK("2013-2014","M2DOSI"), "LC117B",BigDecimal.valueOf(2.0),"DOSI4");
		Promotion resultat = business.creerPromotion(promotionACreer);
		assertThat(resultat.getDateRentree()).isCloseTo(new Date(), 500);
		assertThat(repos.count()).isEqualTo(1);
		
	}
	@Test
	public void doitRechercherToutesLesPromotions() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		Promotion promotion1 = new Promotion(new PromotionPK("2013-2014","M2DOSI"), "LC117B",BigDecimal.valueOf(2.0),"DOSI4");
		Promotion promotion2 = new Promotion(new PromotionPK("2014-2015","M2DOSI"), "LC117R",BigDecimal.valueOf(2.0),"DOSI5");
		business.repos.save(promotion1);
		business.repos.save(promotion2);
		assertThat(repos.count()).isEqualTo(2);
		}
		
	
	@Test
	public void doitRechercherUnePromotionParSigle() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		Promotion promotion = new Promotion(new PromotionPK("2013-2014","M2DOSI"), "LC117B",BigDecimal.valueOf(2.0),"DOSI4");
		business.repos.save(promotion);
		Promotion resultat =  business.findPromotionBySigle("DOSI4");
		assertThat(resultat.getSiglePromotion()).isEqualTo("DOSI4");	
	}
	
	@Test
	public void doitRechercherUnePromotionParLieuRentree() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		Promotion promotion = new Promotion(new PromotionPK("2013-2014","M2DOSI"), "LC117B",BigDecimal.valueOf(2.0),"DOSI4");
		business.repos.save(promotion);
		List<Promotion> resultat =  business.findPromotionByLieuRentree("LC117B");
		assertThat(resultat.get(0).getLieuRentree()).isEqualTo("LC117B");
	}
	
	@Test
	public void doitRechercherUnePromotionId() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		Promotion promotion = new Promotion(new PromotionPK("2013-2014","M2DOSI"), "LC117B",BigDecimal.valueOf(2.0),"DOSI4");
		business.repos.save(promotion);
		Promotion resultat =  business.findPromotionById(new PromotionPK("2013-2014","M2DOSI"));
		assertThat(resultat.getId()).isEqualTo(new PromotionPK("2013-2014","M2DOSI"));	
	}
	
	
	@Test
	public void doitSupprimerPromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		Promotion promotionASupprimer =  new Promotion(new PromotionPK("2013-2014","M2DOSI"), "LC117B",BigDecimal.valueOf(2.0),"DOSI4");
		business.supprimerPromotion(promotionASupprimer.getId());
		assertThat(repos.count()).isEqualTo(0);
		
	}

	
	
	
		class PromotionRepositoryList implements PromotionRepository{
			
			private List<Promotion> data;
			

			public PromotionRepositoryList() {
				super();
				data=Lists.newArrayList();			}

			@Override
			public <S extends Promotion> S save(S entity) {
				data.add(entity);
				 return entity;
								
			}

			@Override
			public <S extends Promotion> Iterable<S> save(Iterable<S> entities) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Promotion findOne(PromotionPK id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean exists(PromotionPK id) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterable<Promotion> findAll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Iterable<Promotion> findAll(Iterable<PromotionPK> ids) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long count() {
				return data.size();
			}

			@Override
			public void delete(PromotionPK id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void delete(Promotion entity) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void delete(Iterable<? extends Promotion> entities) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void deleteAll() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Promotion findBySiglePromotion(String siglePromotion) {
				
				Promotion pro = new Promotion();
				for(Promotion p : data) {
					if(p.getSiglePromotion()==siglePromotion) {
						pro=p;										
					}
				}
				return pro;
			}

			@Override
			public List<Promotion> findByLieuRentree(String lieuRentree) {
				List<Promotion> promos = new ArrayList<>();
				for(Promotion p : data) {
					if(p.getLieuRentree().equals(lieuRentree))
						promos.add(p);
				}
				return promos;
			}

			@Override
			public Promotion findById(PromotionPK id) {
				Promotion pro = new Promotion();
				for(Promotion p : data) {
					if(p.getId().equals(id)) {
						pro=p;
					}
				}
				return pro;
			}

			
			}
			
			
		}
	
	

