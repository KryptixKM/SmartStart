/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.model;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Evenement {
    private int id;
    private String titre;
    private String secteur;
    private String description;
    private float budget;
    private Date dateDebut;
    private int duree;
    private JobOwner jobOwner;

    public Evenement() {
        jobOwner = new JobOwner();
    }

    public Evenement(int id, String titre, String secteur, String description, float budget, Date dateDebut, int duree) {
        this.id = id;
        this.titre = titre;
        this.secteur = secteur;
        this.description = description;
        this.budget = budget;
        this.dateDebut = dateDebut;
        this.duree = duree;
        jobOwner = new JobOwner();
    }

    public Evenement(String titre, String secteur, String description, float budget, Date dateDebut, int duree) {
        this.titre = titre;
        this.secteur = secteur;
        this.description = description;
        this.budget = budget;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.jobOwner = jobOwner;
    }
    
    

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getSecteur() {
        return secteur;
    }

    public String getDescription() {
        return description;
    }

    public float getBudget() {
        return budget;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public int getDuree() {
        return duree;
    }

    public JobOwner getJobOwner() {
        return jobOwner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setJobOwner(JobOwner jobOwner) {
        this.jobOwner = jobOwner;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", titre=" + titre + ", secteur=" + secteur + ", description=" + description + ", budget=" + budget + ", dateDebut=" + dateDebut + ", duree=" + duree + ", jobOwner=" + jobOwner + '}';
    }    
    
}