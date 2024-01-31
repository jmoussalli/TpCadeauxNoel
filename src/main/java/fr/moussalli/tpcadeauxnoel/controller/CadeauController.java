package fr.moussalli.tpcadeauxnoel.controller;

import fr.moussalli.tpcadeauxnoel.dto.CadeauDTO;
import fr.moussalli.tpcadeauxnoel.dto.CadeauDTOnoId;
import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.mapper.CadeauMapper;
import fr.moussalli.tpcadeauxnoel.service.CadeauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class CadeauController {

    @Autowired
    private CadeauService cadeauService;

    // GET /cadeaux
    @GetMapping("cadeaux")
    public List<CadeauDTOnoId> getCadeaux() {
        List<Cadeau> listeC = cadeauService.getAll();
        List<CadeauDTOnoId> listeCadeauDTOnoId = listeC.stream()
                .map(CadeauMapper::convertEntityToDtoNoId)
                .collect(Collectors.toList());
        return listeCadeauDTOnoId;
    }

    // POST /cadeaux
    @PostMapping("cadeaux")
    public ResponseEntity<?> addCadeau(@RequestBody Cadeau cadeau) {
        if (cadeau.getNom() != null && cadeau.getNom().isBlank())
            return ResponseEntity
                    .badRequest()
                    .body("le nom du cadeau est obligatoire");
        else {
            Cadeau c = cadeauService.add(cadeau);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CadeauMapper.convertEntityToDtoNoId(c));
        }
    }

    // GET /cadeaux/4
    @GetMapping("cadeaux/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Optional<Cadeau> optional = cadeauService.findById(id);
        if (optional.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            Cadeau c = optional.get();
            return ResponseEntity.ok(CadeauMapper.convertEntityToDtoNoId(c));
        }
    }

    // DELETE /cadeaux/4
    @DeleteMapping("cadeaux/{id}")
    public void delete(@PathVariable("id") Long id) {
        cadeauService.delete(id);
    }

    // PUT /cadeaux/4
    @PutMapping("cadeaux/{id}")
    public void update(@RequestBody Cadeau cadeau
            , @PathVariable("id") Integer id) {
        cadeauService.update(cadeau);
    }
}
