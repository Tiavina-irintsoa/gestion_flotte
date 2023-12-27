package gestion_flotte.voitures;

import gestion_flotte.voitures.auth.AuthenticationRequest;
import gestion_flotte.voitures.auth.RegisterRequest;
import gestion_flotte.voitures.services.AuthenticationService;
import gestion_flotte.voitures.services.UtilisateurService;
import gestion_flotte.voitures.tools.Util;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class UtilisateurController {

  @Autowired
  private AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<Map<String, Object>> register(
    @RequestBody RegisterRequest request
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    response.put("response", service.register(request));
    return new ResponseEntity<Map<String, Object>>(
      response,
      HttpStatusCode.valueOf(400)
    );
  }

  @PostMapping("/auth")
  public ResponseEntity<Map<String, Object>> auth(
    @RequestBody AuthenticationRequest request
  ) {
    Map<String, Object> response = Util.getDefaultResponse();
    response.put("response", service.authenticate(request));
    return new ResponseEntity<Map<String, Object>>(
      response,
      HttpStatusCode.valueOf(400)
    );
  }
}
