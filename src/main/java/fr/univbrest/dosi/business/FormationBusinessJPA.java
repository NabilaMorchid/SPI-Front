package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component
public class FormationBusinessJPA implements FormationBusiness{


    private FormationRepository repos;

    
    
   @Autowired
   public  FormationBusinessJPA(FormationRepository repos) {
	    this.repos=repos;
   }
   
   
   
   
   @Override
	public Formation creerFormation(Formation formationACreer) {
		formationACreer.setDebutAccreditation(new Date());
	   return repos.save(formationACreer);
 
   
	}

@Override
public List<Formation> recupererToutesLesFormations() {
	
	return (List<Formation>) repos.findAll();
}

@Override
public List<Formation> recupererLaFormationAvecLeNom(String nom) {
	return repos.findByNomFormation(nom);
	
}

@Override
public Formation recupererLaFormationAvecId(String id) {
	return repos.findByCodeFormation(id);
}



@Override
public void supprimerFormation(String codeFormation) {
	repos.delete(repos.findByCodeFormation(codeFormation));
	
}




@Override
public Formation modifierFormation(Formation formationAMaj) {
     
	return repos.save(formationAMaj);
}




@Override
public long recupererCount() {
	// TODO Auto-generated method stub
	return repos.count();
}



	
}
