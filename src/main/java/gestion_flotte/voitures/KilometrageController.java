package gestion_flotte.voitures;

import gestion_flotte.voitures.entities.Kilometrage;
import gestion_flotte.voitures.services.KilometrageService;
import gestion_flotte.voitures.tools.Util;
import java.util.Map;
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

@RestController
@RequestMapping("/kilometrages")
public class KilometrageController {

  @Autowired
  private KilometrageService service;

  @GetMapping
  public ResponseEntity<Map<String, Object>> list() {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      response.put("data", service.list());
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
      Optional<Kilometrage> kilometrage = service.findById(id);
      if (kilometrage.isPresent()) {
        response.put("data", kilometrage.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Kilometrage inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> insert(
    @RequestBody Kilometrage kilometrage
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Kilometrage inserted = service.insert(kilometrage);
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
    @RequestBody Kilometrage kilometrage
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Optional<Kilometrage> to_update = service.findById(id);
      if (to_update.isPresent()) {
        Kilometrage updated = to_update.get();
        updated.update(kilometrage);
        response.put("data", service.insert(updated));
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      response.put("error", "Kilometrage inexistant");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Object>> deleteById(
    @PathVariable("id") String id
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      service.deleteById(id);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
