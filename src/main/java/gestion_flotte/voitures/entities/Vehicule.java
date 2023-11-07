package gestion_flotte.voitures.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="VEHICULE")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idvehicule;

    String matricule;
    @ManyToOne
    @JoinColumn(name="idmarque")
    Marque marque;
    
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public int getIdvehicule() {
        return idvehicule;
    }
    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }
    public Marque getMarque() {
        return marque;
    }
    public void setMarque(Marque marque) {
        this.marque = marque;
    }
    
   
}
