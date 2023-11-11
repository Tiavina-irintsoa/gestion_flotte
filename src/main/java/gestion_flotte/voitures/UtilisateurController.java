package gestion_flotte.voitures;

import gestion_flotte.tools.Util;
import gestion_flotte.voitures.entities.Utilisateur;
import gestion_flotte.voitures.services.UtilisateurService;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UtilisateurController {

  @Autowired
  private UtilisateurService service;

  @PostMapping
  public ResponseEntity<Map<String, Object>> auth(@RequestBody Utilisateur utilisateur) {
    Map<String, Object> response = Util.getDefaultResponse();
    try {
      Optional<Utilisateur> user = service.findByNameAndPassword(utilisateur);
      if (user.isPresent()) {
        response.put("data", user.get());
        return new ResponseEntity<>(response,HttpStatus.OK);
      }
      response.put("error", "Mot de passe ou login incorrect");
      return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      response.put("error", e.getMessage());
      return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
