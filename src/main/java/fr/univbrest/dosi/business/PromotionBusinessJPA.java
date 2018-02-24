package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;

@Component
public class PromotionBusinessJPA implements PromotionBusiness{

	  PromotionRepository repos;

	  @Autowired
	public PromotionBusinessJPA(PromotionRepository repos) {
		this.repos=repos;	}
	  
	  @Override
	  public List<Promotion>recupererToutesLesPromotions(){
		  return (List<Promotion>) repos.findAll();
	  }

	  @Override
	public Promotion creerPromotion(Promotion promotionACreer) {
		promotionACreer.setDateRentree(new Date());;
		return repos.save(promotionACreer);
	}

	  @Override
	public Promotion findPromotionBySigle(String sigle) {
		Promotion promotionRecherche= repos.findBySiglePromotion(sigle);
		return promotionRecherche;
		
	}

	  @Override
	public void supprimerPromotion(PromotionPK id) {

		repos.delete(findPromotionById(id));
	}

   @Override
public Promotion findPromotionById(PromotionPK id) {
		return repos.findById(id);
	}

@Override
public List<Promotion> findPromotionByLieuRentree(String lieuRentree) {
	return (List<Promotion>) repos.findByLieuRentree(lieuRentree);
	
}


	  
	  
}
