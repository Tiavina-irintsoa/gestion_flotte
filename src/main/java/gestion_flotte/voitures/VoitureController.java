package gestion_flotte.voitures;

import gestion_flotte.voitures.entities.Marque;
import gestion_flotte.voitures.entities.Vehicule;
import gestion_flotte.voitures.services.VoitureService;
import gestion_flotte.voitures.tools.Util;

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
  public ResponseEntity<Map<String, Object>> list() {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      response.put("data", voitureService.list());
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello";
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> findById(
    @PathVariable("id") String id
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Optional<Vehicule> vehicule = voitureService.findById(id);
      if (vehicule.isPresent()) {
        response.put("data", vehicule.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Vehicule inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
    @RequestBody Vehicule vehicule
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Vehicule inserted = voitureService.insert(vehicule);
      response.put("data", inserted);

      return new ResponseEntity<>(response, HttpStatus.CREATED);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Map<String, Object>> update(
    @PathVariable("id") String id,
    @RequestBody Vehicule vehicule
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Optional<Vehicule> to_update = voitureService.findById(id);
      if (to_update.isPresent()) {
        Vehicule updated = to_update.get();
        updated.setMarque(new Marque(vehicule.getMarque().getIdMarque()));
        updated.setMatricule(vehicule.getMatricule());
        response.put("data", voitureService.insert(updated));
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Vehicule inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String,Object>> deleteById(@PathVariable("id") String id) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      voitureService.deleteById(id);
      return new ResponseEntity<>(response,HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
