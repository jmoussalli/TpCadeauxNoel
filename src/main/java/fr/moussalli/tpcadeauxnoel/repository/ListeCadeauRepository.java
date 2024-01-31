package fr.moussalli.tpcadeauxnoel.repository;

import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.entity.ListeCadeau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListeCadeauRepository extends JpaRepository<ListeCadeau, Long> {
    ListeCadeau findByNom(String nom);
}
