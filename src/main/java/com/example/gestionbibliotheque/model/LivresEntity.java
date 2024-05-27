package com.example.gestionbibliotheque.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "livres", schema = "bibliotheque", catalog = "")
public class LivresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "livreid", nullable = false)
    private int livreid;
    @Basic
    @Column(name = "titre", nullable = false, length = 255)
    private String titre;
    @Basic
    @Column(name = "auteur", nullable = false, length = 255)
    private String auteur;
    @Basic
    @Column(name = "categorie", nullable = false, length = 255)
    private String categorie;
    @Basic
    @Column(name = "isbn", nullable = true, length = 20)
    private String isbn;
    @Basic
    @Column(name = "datepublication", nullable = true)
    private Date datepublication;
    @Basic
    @Column(name = "nombreexemplaires", nullable = true)
    private Integer nombreexemplaires;
    @Basic
    @Column(name = "maisonedition", nullable = false, length = 255)
    private String maisonedition;

    public int getLivreid() {
        return livreid;
    }

    public void setLivreid(int livreid) {
        this.livreid = livreid;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Date datepublication) {
        this.datepublication = datepublication;
    }

    public Integer getNombreexemplaires() {
        return nombreexemplaires;
    }

    public void setNombreexemplaires(Integer nombreexemplaires) {
        this.nombreexemplaires = nombreexemplaires;
    }

    public String getMaisonedition() {
        return maisonedition;
    }

    public void setMaisonedition(String maisonedition) {
        this.maisonedition = maisonedition;
    }
}
