package fr.moussalli.tpcadeauxnoel.entity;

import jakarta.persistence.*;

import java.util.Optional;



@Entity
public class Cadeau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;
    private String description;
    private Double prix;
    @ManyToOne
    @JoinColumn(name = "liste_cadeau_id")
    private ListeCadeau listeCadeau;

    public Cadeau() {
    }

    public Cadeau(String nom, String description, Double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Cadeau(Long id,
                  String nom,
                  String description,
                  Optional<Double> prixDouble,
                  ListeCadeau listeCadeau) {
        this.nom = nom;
        this.description = description;
        this.prix = prixDouble.get();
        this.listeCadeau = listeCadeau;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public ListeCadeau getListeCadeau() {
        return listeCadeau;
    }

    public void setListeCadeau(ListeCadeau listeCadeau) {
        this.listeCadeau = listeCadeau;
    }

    @Override
    public String toString() {
        return "Cadeau{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", listeCadeau=" + listeCadeau +
                '}';
    }
}
