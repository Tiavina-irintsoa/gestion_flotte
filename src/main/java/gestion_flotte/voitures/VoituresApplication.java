package gestion_flotte.voitures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @EnableJpaRepositories({ "gestion_flotte.voitures.repositories" })
// @EntityScan(basePackages = { "gestion_flotte.voitures.entities" })
@ComponentScan(
  basePackages = {
    "gestion_flotte.voitures.repositories",
    "gestion_flotte.voitures.services",
    "gestion_flotte.voitures",
    "gestion_flotte.voitures.requestFilter",
    "gestion_flotte.voitures.entryPoints",
  }
)
public class VoituresApplication {

  public static void main(String[] args) {
    SpringApplication.run(VoituresApplication.class, args);
  }
}
