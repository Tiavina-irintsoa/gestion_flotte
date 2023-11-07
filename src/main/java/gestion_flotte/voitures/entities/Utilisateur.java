package gestion_flotte.voitures.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilisateur {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int idUtilisateur;

  String login;
  String motdepasse;

  public int getIdUtilisateur() {
    return idUtilisateur;
  }

  public void setIdUtilisateur(int idUtilisateur) {
    this.idUtilisateur = idUtilisateur;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getMotdepasse() {
    return motdepasse;
  }

  public void setMotdepasse(String motdepasse) {
    this.motdepasse = motdepasse;
  }

  @Override
  public String toString() {
    return "Utilisateur [login=" + login + ", motdepasse=" + motdepasse + "]";
  }
}
