package com.example.gestionbibliotheque.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "emprunts", schema = "bibliotheque", catalog = "")
public class EmpruntsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "empruntid", nullable = false)
    private int empruntid;
    @Basic
    @Column(name = "livreid", nullable = true)
    private Integer livreid;
    @Basic
    @Column(name = "adherentcin", nullable = false)
    private int adherentcin;
    @Basic
    @Column(name = "dateemprunt", nullable = true)
    private LocalDate dateemprunt;
    @Basic
    @Column(name = "dateretourprevue", nullable = true)
    private LocalDate dateretourprevue;
    @Basic
    @Column(name = "dateretoureffective", nullable = true)
    private LocalDate dateretoureffective;

    public int getEmpruntid() {
        return empruntid;
    }

    public void setEmpruntid(int empruntid) {
        this.empruntid = empruntid;
    }

    public Integer getLivreid() {
        return livreid;
    }

    public void setLivreid(Integer livreid) {
        this.livreid = livreid;
    }

    public int getAdherentcin() {
        return adherentcin;
    }

    public void setAdherentcin(int adherentcin) {
        this.adherentcin = adherentcin;
    }

    public LocalDate getDateemprunt() {
        return dateemprunt;
    }

    public void setDateemprunt(LocalDate dateemprunt) {
        this.dateemprunt = dateemprunt;
    }

    public LocalDate getDateretourprevue() {
        return dateretourprevue;
    }

    public void setDateretourprevue(LocalDate dateretourprevue) {
        this.dateretourprevue = dateretourprevue;
    }

    public LocalDate getDateretoureffective() {
        return dateretoureffective;
    }

    public void setDateretoureffective(LocalDate dateretoureffective) {
        this.dateretoureffective = dateretoureffective;
    }
}
