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
import fr.univbrest.dosi.bean.Enseignant;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class EnseignantRepositoryTest {

	@Autowired
	EnseignantRepository enseignantRepo;

	@Before
	public void setup() {
		Enseignant enseignant1 = new Enseignant("adresse1", "20200", "nom1", "ville1");
		Enseignant enseignant2 = new Enseignant("adresse2", "20500", "nom2", "ville2");

		enseignantRepo.save(enseignant1);
		enseignantRepo.save(enseignant2);

	}


	
}
