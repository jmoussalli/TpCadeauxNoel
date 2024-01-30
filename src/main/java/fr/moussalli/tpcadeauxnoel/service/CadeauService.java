package fr.moussalli.tpcadeauxnoel.service;

import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.repository.CadeauRepository;
import fr.moussalli.tpcadeauxnoel.repository.ListeCadeauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadeauService {

    @Autowired
    private CadeauRepository cadeauRepository;

    @Autowired
    private ListeCadeauRepository listeCadeauRepository;

    public Cadeau add(Cadeau c) {
        if (c.getListeCadeau() != null && c.getListeCadeau().getId() == null) {
            listeCadeauRepository.save(c.getListeCadeau());
        }
        return cadeauRepository.save(c);
    }

    public List<Cadeau> getAll() {
        return cadeauRepository.findAll();
    }

    public Optional<Cadeau> findById(Long id) {
        return cadeauRepository.findById(id);
    }

    public void delete(Long id) {
        cadeauRepository.deleteById(id);
    }

    public void update(Cadeau cadeau) {
        cadeauRepository.save(cadeau);
    }
}
