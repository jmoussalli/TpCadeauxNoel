package fr.moussalli.tpcadeauxnoel.mapper;


import fr.moussalli.tpcadeauxnoel.dto.CadeauDTO;
import fr.moussalli.tpcadeauxnoel.dto.CadeauDTOnoId;
import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.service.ListeCadeauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CadeauMapper {

    @Autowired
    private static ListeCadeauService listeCadeauService;

    public static CadeauDTO convertEntityToDto(Cadeau entity) {
        CadeauDTO dto = new CadeauDTO(
                entity.getId(),
                entity.getNom(),
                entity.getDescription(),
                entity.getPrix(),
                entity.getListeCadeau()
        );
        return dto;
    }

    public static CadeauDTOnoId convertEntityToDtoNoId(Cadeau entity) {
        CadeauDTOnoId dtOnoId = new CadeauDTOnoId(
                entity.getNom(),
                entity.getDescription(),
                entity.getPrix(),
                entity.getListeCadeau()
        );
        return dtOnoId;
    }

    public static Cadeau convertDtoToEntity(CadeauDTO dto) {
        String prixString = dto.getPrix();
        if (prixString != null && prixString.length() > 2) {
            prixString = prixString.substring(0, prixString.length() - 2);
        }
        Optional<Double> prixDouble;
        try {
            prixDouble = Optional.of(Double.parseDouble(prixString));
        } catch (NumberFormatException e) {
            prixDouble = Optional.empty();
        }
        Cadeau entity = new Cadeau(
                dto.getId(),
                dto.getNom(),
                dto.getDescription(),
                prixDouble,
                listeCadeauService.findByNom(dto.getNomListeCadeau())
        );
        return entity;
    }
}
