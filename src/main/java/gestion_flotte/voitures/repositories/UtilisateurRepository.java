package gestion_flotte.voitures.repositories;

import gestion_flotte.voitures.entities.Utilisateur;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository
  extends JpaRepository<Utilisateur, Integer> {
  Optional<Utilisateur> findByLoginAndMotdepasse(String login, String motdepasse);
}
