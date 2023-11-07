package gestion_flotte.voitures;

import gestion_flotte.voitures.entities.Marque;
import gestion_flotte.voitures.entities.Vehicule;
import gestion_flotte.voitures.services.VoitureService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voitures")
public class VoitureController {

  @Autowired
  private VoitureService voitureService;

  @GetMapping
  public List<Vehicule> list() {
    return voitureService.list();
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello";
  }

  @GetMapping("/{id}")
  public Optional<Vehicule> findById(@PathVariable("id") String id) {
    return voitureService.findById(id);
  }

  @PostMapping
  public ResponseEntity<Vehicule> insert(@RequestBody Vehicule vehicule) {
    try {
      Vehicule inserted = voitureService.insert(vehicule);
      return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Vehicule> update(
    @PathVariable("id") String id,
    @RequestBody Vehicule vehicule
  ) {
    Optional<Vehicule> to_update = voitureService.findById(id);
    if (to_update.isPresent()) {
      Vehicule updated = to_update.get();
      updated.setMarque(new Marque(vehicule.getMarque().getIdMarque()));
      updated.setMatricule(vehicule.getMatricule());
      return new ResponseEntity<Vehicule>(
        voitureService.insert(updated),
        HttpStatus.OK
      );
    }
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
    try {
      voitureService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
