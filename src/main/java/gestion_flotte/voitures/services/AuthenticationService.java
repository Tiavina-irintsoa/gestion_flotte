package gestion_flotte.voitures.services;

import gestion_flotte.voitures.auth.AuthenticationRequest;
import gestion_flotte.voitures.auth.AuthenticationResponse;
import gestion_flotte.voitures.auth.RegisterRequest;
import gestion_flotte.voitures.entities.Utilisateur;
import gestion_flotte.voitures.repositories.UtilisateurRepository;
import gestion_flotte.voitures.tools.JwtUtil;
import gestion_flotte.voitures.tools.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  @Autowired
  private UtilisateurRepository utilisateurRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = new Utilisateur();
    user.setLogin(request.getLogin());
    user.setMotdepasse(passwordEncoder.encode(request.getMotDePasse()));
    user.setRole(Role.USER);
    utilisateurRepository.save(user);
    var jwtToken = jwtUtil.generateToken(user);
    return new AuthenticationResponse(jwtToken);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    System.out.println(utilisateurRepository.findByLogin(request.getLogin()));
    System.out.println(request.getLogin());
    System.out.println(request.getMotDePasse());
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getLogin(),
        request.getMotDePasse()
      )
    );
    var user = utilisateurRepository
      .findByLogin(request.getLogin())
      .orElseThrow();
    var token = jwtUtil.generateToken(user);

    AuthenticationResponse response = new AuthenticationResponse(token);
    return response;
  }
}
