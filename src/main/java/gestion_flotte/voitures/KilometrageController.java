package gestion_flotte.voitures;

import java.util.List;
import java.util.Optional;

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

import gestion_flotte.voitures.entities.Kilometrage;
import gestion_flotte.voitures.services.KilometrageService;

@RestController
@RequestMapping("/kilometrage")
public class KilometrageController {

  @Autowired
  private KilometrageService service;

  @GetMapping
  public List<Kilometrage> list() {
    return service.list();
  }

  @GetMapping("/{id}")
  public Optional<Kilometrage> findById(@PathVariable("id") String id) {
    return service.findById(id);
  }

  @PostMapping
  public ResponseEntity<Kilometrage> insert(
    @RequestBody Kilometrage kilometrage
  ) {
    try {
      Kilometrage inserted = service.insert(kilometrage);
      return new ResponseEntity<>(inserted, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Kilometrage> update(
    @PathVariable("id") String id,
    @RequestBody Kilometrage kilometrage
  ) {
    Optional<Kilometrage> to_update = service.findById(id);
    if (to_update.isPresent()) {
      Kilometrage updated = to_update.get();
      updated.setDate(kilometrage.getDate());
      updated.setFinKm(kilometrage.getFinKm());
      updated.setDebutKm(kilometrage.getDebutKm());
      updated.setVehicule(kilometrage.getVehicule());
      return new ResponseEntity<Kilometrage>(
        service.insert(updated),
        HttpStatus.OK
      );
    }
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
    try {
      service.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
