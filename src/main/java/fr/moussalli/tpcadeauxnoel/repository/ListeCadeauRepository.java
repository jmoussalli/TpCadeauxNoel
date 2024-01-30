package fr.moussalli.tpcadeauxnoel.repository;

import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.entity.ListeCadeau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListeCadeauRepository extends JpaRepository<ListeCadeau, Long> {
}
