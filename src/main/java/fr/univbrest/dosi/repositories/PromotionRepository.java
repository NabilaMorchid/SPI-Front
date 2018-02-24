package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

public interface PromotionRepository extends CrudRepository<Promotion, PromotionPK>{


	Promotion findBySiglePromotion(String siglePromotion);
	List<Promotion> findByLieuRentree(String lieuRentree);
	Promotion findById(PromotionPK id);
	
	}
