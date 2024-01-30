package fr.moussalli.tpcadeauxnoel;

import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.repository.CadeauRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CadeauRepositoryTests {

    @Autowired
    CadeauRepository cadeauRepository;

	@Test
	void testSaveCadeau() {
		Cadeau cadeau = new Cadeau("Bureau Assis Debout", "Bureau assis-debout électrique, idéal pour le télétravail", 349.99d);
		cadeauRepository.save(cadeau);
		System.out.println(cadeau);
	}

    @Test
    void testFindByNom() {
        Optional<Cadeau> opt = cadeauRepository.findById(1l);
        if (opt.isEmpty()){
            System.out.println("Cadeau non trouvé");
        } else {
            System.out.println(opt.get());
        }
    }

}
