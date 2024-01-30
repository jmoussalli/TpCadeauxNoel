package fr.moussalli.tpcadeauxnoel;

import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.entity.ListeCadeau;
import fr.moussalli.tpcadeauxnoel.service.CadeauService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ServiceTests {

    @Autowired
    CadeauService cadeauService;

    @Test
    void addCadeau() {
        Cadeau cadeau = new Cadeau("PC portable", "Un PC portable puissant pour travailler et jouer", 999.99d);
        cadeauService.add(cadeau);
        System.out.println(cadeau);
    }

    @Test
    void createCadeauWithListeCadeauTest() {
        ListeCadeau listeCadeau = new ListeCadeau("Cadeaux de Noël","Liste des cadeaux de Noël" );
        Cadeau cadeau = new Cadeau("Smartphone", "Pixel 8 pro", 899.0d);
        cadeau.setListeCadeau(listeCadeau);
        cadeauService.add(cadeau);
        System.out.println(cadeau);
    }

    @Test
    void getAllCadeau() {
        List<Cadeau> cadeauList = cadeauService.getAll();
        if (cadeauList.isEmpty()){
            System.out.println("Cadeau non trouvé");
        } else {
            cadeauList.stream().forEach(cadeau -> System.out.println(cadeau));
        }
    }

    @Test
    void getCadeauById() {
        Optional<Cadeau> opt = cadeauService.findById(1l);
        if (opt.isEmpty()){
            System.out.println("Cadeau non trouvé");
        } else {
            System.out.println(opt.get());
        }
    }


}
