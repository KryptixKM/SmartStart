/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.model;

/**
 *
 * @author USER
 */
public class JobOwner extends User{
    public JobOwner(String id, String password, String nom, String prenom, String email, String addresse, String telephone, String type, String photo) {
        super(id, password, nom, prenom, email, addresse, telephone, type, photo);
    }

 
    public JobOwner() {
    }
    
}
