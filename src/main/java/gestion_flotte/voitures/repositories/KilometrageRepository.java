package gestion_flotte.voitures.repositories;

import gestion_flotte.voitures.entities.Kilometrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KilometrageRepository
  extends JpaRepository<Kilometrage, Integer> {}
