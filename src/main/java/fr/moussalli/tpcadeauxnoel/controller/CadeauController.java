package fr.moussalli.tpcadeauxnoel.controller;

import fr.moussalli.tpcadeauxnoel.entity.Cadeau;
import fr.moussalli.tpcadeauxnoel.service.LettreAuPereNoel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CadeauController {

    @Autowired
    private LettreAuPereNoel lettreAuPereNoel;

    // GET /cadeaux
    @GetMapping("cadeaux")
    public List<Cadeau> getCadeaux(){
        return lettreAuPereNoel.getAll();
    }

    // POST /cadeaux
    @PostMapping("cadeaux")
    public ResponseEntity<?> addCadeau(@RequestBody Cadeau cadeau){
       if(cadeau.getNom() != null && cadeau.getNom().isBlank())
           return ResponseEntity
                   .badRequest()
                   .body("le nom du cadeau est obligatoire");
       else {
           lettreAuPereNoel.add(cadeau);
           return ResponseEntity.status(HttpStatus.CREATED).body(cadeau);
       }
    }

    // GET /cadeaux/4
    @GetMapping("cadeaux/{id}")
    public ResponseEntity<Cadeau> getById(@PathVariable("id") Long id){
        Optional<Cadeau> optional = lettreAuPereNoel.findById(id);
        if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            Cadeau c = optional.get();
            return ResponseEntity.ok(c);
        }
    }

    // DELETE /cadeaux/4
    @DeleteMapping("cadeaux/{id}")
    public void delete(@PathVariable("id") Long id){
        lettreAuPereNoel.delete(id);
    }

    // PUT /cadeaux/4
    @PutMapping("cadeaux/{id}")
    public void update(@RequestBody Cadeau cadeau
                    , @PathVariable("id") Integer id){
        lettreAuPereNoel.update(cadeau);
    }
}
