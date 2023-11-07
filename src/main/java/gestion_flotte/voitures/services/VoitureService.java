package gestion_flotte.voitures.services;

import gestion_flotte.voitures.entities.Vehicule;
import gestion_flotte.voitures.repositories.VoitureRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class VoitureService {

  @Autowired
  private VoitureRepository voitureRepository;

  public List<Vehicule> list() {
    return voitureRepository.findAll();
  }

  public Vehicule insert(Vehicule vehicule) {
    return voitureRepository.save(vehicule);
  }
  public Optional<Vehicule> findById(String matricule){
    return voitureRepository.findById(Integer.valueOf(matricule));
  }
  public void deleteById(String id){
    voitureRepository.deleteById(Integer.valueOf(id));
  }
}
