/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import smartstart.database.DatabaseHandler;
import smartstart.model.Evenement;
import smartstart.model.JobOwner;

/**
 *
 * @author USER
 */
public class EvenementService implements IService<Evenement> {

    private Connection connection;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;

    public EvenementService() {
        connection = DatabaseHandler.getInstance().getConnection();
    }

    @Override
    public boolean add(Evenement t) {
        String addQry = "INSERT INTO evenement(titre_evenement,secteur,description,budget,date_debut,duree,id) VALUES(?,?,?,?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(addQry);
            pstmt.setString(1, t.getTitre());
            pstmt.setString(2, t.getSecteur());
            pstmt.setString(3, t.getDescription());
            pstmt.setFloat(4, t.getBudget());
            pstmt.setDate(5, t.getDateDebut());
            pstmt.setInt(6, t.getDuree());
            pstmt.setString(7, t.getJobOwner().getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    @Override
    public boolean delete(Evenement t) {
        String deleteQry = "DELETE FROM evenement WHERE id_evenement= ?";
        try {
            pstmt = connection.prepareStatement(deleteQry);
            pstmt.setInt(1, t.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Evenement t) {
        String updateQry = "Update evenement set (titre_evenement = ?,secteur = ?,description = ?,budget = ?,date_debut = ?,duree = ?) where id_evenement = ?";
        try {
            pstmt = connection.prepareStatement(updateQry);
            pstmt.setString(1, t.getTitre());
            pstmt.setString(2, t.getSecteur());
            pstmt.setString(3, t.getDescription());
            pstmt.setFloat(4, t.getBudget());
            pstmt.setDate(5, t.getDateDebut());
            pstmt.setInt(6, t.getDuree());
            pstmt.setInt(8, t.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Evenement getById(int id) {
        String readQry = "SELECT * FROM evenement e, user jo WHERE e.id = jo.id and id_evenement=?";
        Evenement e = new Evenement();
        JobOwner jo = new JobOwner();
        try {
           pstmt = connection.prepareStatement(readQry);
           pstmt.setInt(1, id);
           rs = pstmt.executeQuery();
            while (rs.next()) {
                e.setTitre(rs.getString("titre_evenement"));
                e.setTitre(rs.getString("secteur"));
                e.setDescription(rs.getString("description"));
                e.setBudget(rs.getFloat("budget"));
                e.setDateDebut(rs.getDate("date_debut"));
                e.setDuree(rs.getInt("duree"));
                jo.setId(rs.getString(9));
                jo.setNom(rs.getString(10));
                jo.setPrenom(rs.getString(11));
                jo.setPassword(rs.getString(12));
                jo.setEmail(rs.getString(13));
                jo.setAddresse(rs.getString(14));
                jo.setTelephone(rs.getString(15));
                e.setJobOwner(jo);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    @Override
    public List<Evenement> getAll() {
        List<Evenement> list = new ArrayList<>();
        //Date datemax = new Date(0);
        String readAllQry = "select * from evenement";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(readAllQry);
            
            while (rs.next()) {
                //datemax = rs.getDate("date_debut");
                //String d = datemax.toString();
                list.add(new Evenement(rs.getInt("id_evenement"), rs.getString("titre_evenement"), rs.getString("secteur"), rs.getString("description"), rs.getFloat("budget"), rs.getDate("date_debut"), rs.getInt("duree")));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Evenement> getEvenementsOfJobOwner(String id) {
        List<Evenement> list = new ArrayList<>();
        String getAllQry = "Select * from evenement where id = ?";
        try {
            pstmt = connection.prepareStatement(getAllQry);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Evenement(rs.getInt("id_evenement"), rs.getString("titre_evenement"), rs.getString("secteur"), rs.getString("description"), rs.getFloat("budget"), rs.getDate("date_debut"), rs.getInt("duree")));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EvenementService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
