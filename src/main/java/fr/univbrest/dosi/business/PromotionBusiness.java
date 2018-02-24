package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

public interface PromotionBusiness {

	List<Promotion> recupererToutesLesPromotions();

	Promotion creerPromotion(Promotion promotionACreer);

	Promotion findPromotionBySigle(String sigle);

	void supprimerPromotion(PromotionPK id);

	Promotion findPromotionById(PromotionPK id);

	List<Promotion> findPromotionByLieuRentree(String lieuRentree);
}
