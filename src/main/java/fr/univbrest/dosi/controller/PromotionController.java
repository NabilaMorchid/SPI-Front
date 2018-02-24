package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusiness;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

	private PromotionBusiness business;

	@Autowired
	public PromotionController(PromotionBusiness business) {
		this.business = business;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> recupererToutesLesPromotions() {

		return business.recupererToutesLesPromotions();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Promotion creerPromotion(@RequestBody Promotion promotionACreer) {
		return business.creerPromotion(promotionACreer);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sigle/{siglePromotion}")
	public Promotion findPromotionBySigle(@PathVariable String siglePromotion) {
		return business.findPromotionBySigle(siglePromotion);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/lieuRentree/{lieuRentree}")
	public List<Promotion> findPromotionByLieuRentree(@PathVariable String lieuRentree) {
		return business.findPromotionByLieuRentree(lieuRentree);

	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{annee}/{code}")
	public Promotion findPromotionById(@PathVariable String annee,@PathVariable String code) {

		PromotionPK id = new PromotionPK(annee, code);
		return business.findPromotionById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/suppr/{annee}/{code}")
	public void supprimerPromotion(@PathVariable String annee,@PathVariable String code ) {
		PromotionPK id = new PromotionPK(annee, code);
		business.supprimerPromotion(id);
	}
}
