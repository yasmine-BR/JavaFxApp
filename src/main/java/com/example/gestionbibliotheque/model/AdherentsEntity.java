package com.example.gestionbibliotheque.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "adherents", schema = "bibliotheque", catalog = "")
public class AdherentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cin", nullable = false)
    private int cin;
    @Basic
    @Column(name = "nom", nullable = false, length = 100)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = true, length = 100)
    private String prenom;
    @Basic
    @Column(name = "adresse", nullable = true, length = 255)
    private String adresse;
    @Basic
    @Column(name = "telephone", nullable = true, length = 15)
    private String telephone;
    @Basic
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "dateinscription", nullable = true)
    private LocalDate dateinscription;
    @Basic
    @Column(name = "typeadherent", nullable = false, length = 100)
    private String typeadherent;
    @Basic
    @Column(name = "departement", nullable = false, length = 255)
    private String departement;

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(LocalDate dateinscription) {
        this.dateinscription = dateinscription;
    }

    public String getTypeadherent() {
        return typeadherent;
    }

    public void setTypeadherent(String typeadherent) {
        this.typeadherent = typeadherent;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
}
