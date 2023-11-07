package gestion_flotte.voitures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion_flotte.voitures.entities.Vehicule;

@Repository
public interface VoitureRepository extends JpaRepository<Vehicule, Integer> {}
