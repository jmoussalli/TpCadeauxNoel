package fr.moussalli.tpcadeauxnoel.dto;

import fr.moussalli.tpcadeauxnoel.entity.ListeCadeau;

import java.io.Serializable;

/**
 * DTO for {@link fr.moussalli.tpcadeauxnoel.entity.Cadeau}
 */
public class CadeauDTOnoId implements Serializable {
    private final String nom;
    private final String description;
    private final String prix;
    private final String nomListeCadeau;

    public CadeauDTOnoId(String nom, String description, Double prix, ListeCadeau listeCadeau) {
        this.nom = nom;
        this.description = description;
        this.prix = prix.toString()+" €";
        this.nomListeCadeau = listeCadeau.getNom();
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getPrix() {
        return prix;
    }

    public String getNomListeCadeau() {
        return nomListeCadeau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CadeauDTOnoId cadeauDto)) return false;

        if (getNom() != null ? !getNom().equals(cadeauDto.getNom()) : cadeauDto.getNom() != null) return false;
        if (getDescription() != null ? !getDescription().equals(cadeauDto.getDescription()) : cadeauDto.getDescription() != null)
            return false;
        if (!getPrix().equals(cadeauDto.getPrix())) return false;
        return getNomListeCadeau() != null ? getNomListeCadeau().equals(cadeauDto.getNomListeCadeau()) : cadeauDto.getNomListeCadeau() == null;
    }

    @Override
    public int hashCode() {
        int result = getNom() != null ? getNom().hashCode() : 0;
        result = 31 * result + (getNom() != null ? getNom().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getPrix().hashCode();
        result = 31 * result + (getNomListeCadeau() != null ? getNomListeCadeau().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CadeauDTO{" +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix='" + prix + '\'' +
                ", nomListeCadeau='" + nomListeCadeau + '\'' +
                '}';
    }
}