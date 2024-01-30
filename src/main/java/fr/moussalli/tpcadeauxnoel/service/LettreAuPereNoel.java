package fr.moussalli.tpcadeauxnoel.service;

import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.repository.CadeauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LettreAuPereNoel {

    @Autowired
    private CadeauRepository cadeauRepository;

    public void add(Cadeau c) {
        cadeauRepository.save(c);
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
