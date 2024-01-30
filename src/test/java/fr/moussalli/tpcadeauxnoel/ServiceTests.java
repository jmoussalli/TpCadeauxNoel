package fr.moussalli.tpcadeauxnoel;

import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.service.LettreAuPereNoel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ServiceTests {

    @Autowired
    LettreAuPereNoel lettreAuPereNoel;

    @Test
    void addCadeau() {
        Cadeau cadeau = new Cadeau("PC portable", "Un PC portable puissant pour travailler et jouer", 999.99d);
        lettreAuPereNoel.add(cadeau);
        System.out.println(cadeau);

    }

    @Test
    void getAllCadeau() {
        List<Cadeau> cadeauList = lettreAuPereNoel.getAll();
        if (cadeauList.isEmpty()){
            System.out.println("Cadeau non trouvé");
        } else {
            cadeauList.stream().forEach(cadeau -> System.out.println(cadeau));
        }
    }

    @Test
    void getCadeauById() {
        Optional<Cadeau> opt = lettreAuPereNoel.findById(1l);
        if (opt.isEmpty()){
            System.out.println("Cadeau non trouvé");
        } else {
            System.out.println(opt.get());
        }
    }


}
