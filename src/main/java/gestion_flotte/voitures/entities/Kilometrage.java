package gestion_flotte.voitures.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.sql.Date;
@Entity
public class Kilometrage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int idKilometrage;

  @ManyToOne
  @JoinColumn(name="idvehicule")
  Vehicule vehicule;

  Date date;
  double debutKm;
  double finKm;

  public int getIdKilometrage() {
    return idKilometrage;
  }

  public void setIdKilometrage(int idKilometrage) {
    this.idKilometrage = idKilometrage;
  }

  public Vehicule getVehicule() {
    return vehicule;
  }

  public void setVehicule(Vehicule vehicule) {
    this.vehicule = vehicule;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getDebutKm() {
    return debutKm;
  }

  public void setDebutKm(double debutKm) {
    this.debutKm = debutKm;
  }

  public double getFinKm() {
    return finKm;
  }

  public void setFinKm(double finKm) {
    this.finKm = finKm;
  }
}
