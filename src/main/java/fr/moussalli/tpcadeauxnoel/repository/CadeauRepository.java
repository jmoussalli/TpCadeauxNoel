package fr.moussalli.tpcadeauxnoel.repository;

import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadeauRepository extends JpaRepository<Cadeau, Long> {
}
