/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.model;

import java.util.Objects;

/**
 *
 * @author USER
 */
public class Participation {
    private String titre;
    private String description;
    private Evenement evenement;
    private Freelance freelancer;
    private Livrable livrable;

    public Participation() {
        evenement =  new Evenement();
        freelancer = new Freelance();
        livrable = new Livrable();
    }

    public Participation(String titre, String description) {
        this.titre = titre;
        this.description = description;
        evenement =  new Evenement();
        freelancer = new Freelance();
        livrable = new Livrable();
    }

    public Participation(String titre, String description, Evenement evenement, Freelance freelancer, Livrable livrable) {
        this.titre = titre;
        this.description = description;
        this.evenement = evenement;
        this.freelancer = freelancer;
        this.livrable = livrable;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public Freelance getFreelancer() {
        return freelancer;
    }

    public Livrable getLivrable() {
        return livrable;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public void setFreelancer(Freelance freelancer) {
        this.freelancer = freelancer;
    }

    public void setLivrable(Livrable livrable) {
        this.livrable = livrable;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Participation other = (Participation) obj;
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Participation{" + "titre=" + titre + ", description=" + description + ", evenement=" + evenement + ", freelancer=" + freelancer + ", livrable=" + livrable + '}';
    }
    
    
    
}
