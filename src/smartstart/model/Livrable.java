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
public class Livrable {
    private int idL;
    private String titre;
    private String type;
    private String version;

    public Livrable(){
        
    }

      public Livrable(int idL, String titre, String type, String version) {
        this.idL = idL;
        this.titre = titre;
        this.type = type;
        this.version = version;
    }
      
      public Livrable(int idL, String titre, String type){
          this.idL=idL;
          this.titre=titre;
          this.type=type;
      }
      
      public Livrable(String titre, String type, String version){
        this.titre = titre;
        this.type = type;
        this.version = version;
      }
      
    public int getidL() {
        return idL;
    }

    public void setidL(int idL) {
        this.idL = idL;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Livrable{" + "idL=" + idL + ", titre=" + titre + ", type=" + type + ", version=" + version + '}';
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
        final Livrable other = (Livrable) obj;
        if (this.idL != other.idL) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
}
