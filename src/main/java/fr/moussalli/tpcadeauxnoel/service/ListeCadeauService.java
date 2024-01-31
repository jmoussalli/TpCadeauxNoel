package fr.moussalli.tpcadeauxnoel.service;

import fr.moussalli.tpcadeauxnoel.entity.ListeCadeau;
import fr.moussalli.tpcadeauxnoel.repository.ListeCadeauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListeCadeauService {

    @Autowired
    private ListeCadeauRepository listeCadeauRepository;

    public ListeCadeau findByNom(String nom) {
        return listeCadeauRepository.findByNom(nom);
    }

}
