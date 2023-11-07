package gestion_flotte.voitures.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Marque {
    @Id
    int idMarque;
    
    String nomMarque ;
    public Marque() {
    }
    public Marque(int idMarque) {
        setIdMarque(idMarque);
    }
    public int getIdMarque() {
        return idMarque;
    }
    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }
    public String getNomMarque() {
        return nomMarque;
    }
    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }
    

}
