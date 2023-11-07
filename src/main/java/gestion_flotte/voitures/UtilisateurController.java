package gestion_flotte.voitures;

import gestion_flotte.voitures.entities.Utilisateur;
import gestion_flotte.voitures.services.UtilisateurService;
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
  public ResponseEntity<HttpStatus> auth(@RequestBody Utilisateur utilisateur) {
    System.out.println(utilisateur);
    try {
      Optional<Utilisateur> user = service.findByNameAndPassword(utilisateur);
      if (user.isPresent()) {
        return new ResponseEntity<>(HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
