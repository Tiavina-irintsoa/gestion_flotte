package gestion_flotte.voitures.auth;

public class RegisterRequest {

  private String login;
  private String motDePasse;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }
}
