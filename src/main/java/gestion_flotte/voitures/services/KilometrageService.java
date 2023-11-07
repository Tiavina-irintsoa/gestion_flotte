package gestion_flotte.voitures.services;

import gestion_flotte.voitures.entities.Kilometrage;
import gestion_flotte.voitures.repositories.KilometrageRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KilometrageService {

  @Autowired
  private KilometrageRepository kilometrageRepository;

  public List<Kilometrage> list() {
    return kilometrageRepository.findAll();
  }

  public Kilometrage insert(Kilometrage Kilometrage) {
    return kilometrageRepository.save(Kilometrage);
  }

  public Optional<Kilometrage> findById(String matricule) {
    return kilometrageRepository.findById(Integer.valueOf(matricule));
  }

  public void deleteById(String id) {
    kilometrageRepository.deleteById(Integer.valueOf(id));
  }
}
