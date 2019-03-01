/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.service;

import java.sql.Connection;
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
import smartstart.model.Freelance;
import smartstart.model.Livrable;
import smartstart.model.Participation;

/**
 *
 * @author USER
 */
public class ParticipationService implements IService<Participation> {

    private Connection connection;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;

    public ParticipationService() {
        connection = DatabaseHandler.getInstance().getConnection();
    }

    @Override
    public boolean add(Participation t) {
        String addQry = "INSERT INTO participation(id_evenement, id_user, titre_participation, description, id_livrable) VALUES(?,?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(addQry);
            pstmt.setInt(1, t.getEvenement().getId());
            pstmt.setString(2, t.getFreelancer().getId());
            pstmt.setString(3, t.getTitre());
            pstmt.setString(4, t.getDescription());
            pstmt.setInt(5, t.getLivrable().getidL());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Participation t) {
        String deleteQry = "DELETE * FROM participation WHERE id_evenement = ? and id_user = ?";
        try {
            pstmt = connection.prepareStatement(deleteQry);
            pstmt.setInt(1, t.getEvenement().getId());
            pstmt.setString(2, t.getFreelancer().getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Participation t) {
        String updateQry = "Update participation set (titre_participation = ?,description = ?) where id_evenement = ? and id_user = ?";
        try {
            pstmt = connection.prepareStatement(updateQry);
            pstmt.setString(1, t.getTitre());
            pstmt.setString(2, t.getDescription());
            pstmt.setInt(3, t.getEvenement().getId());
            pstmt.setString(4, t.getFreelancer().getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Participation getByIds(int ide, String idf) {
        String readQry = " select * from participation p, evenement e, user f, livrable l where p.id_evenement = e.id_evenement and p.id_user = f.id and p.id_evenement= ? and p.id_user = ? GROUP BY e.id_evenement ORDER BY e.id_evenement";
        Participation p = new Participation();
        Evenement e = new Evenement();
        Freelance f = new Freelance();
        Livrable l = new Livrable();
        try {
            pstmt = connection.prepareStatement(readQry);
            pstmt.setInt(1, ide);
            pstmt.setString(2, idf);
            rs = pstmt.executeQuery(readQry);
            while (rs.next()) {
                p.setTitre(rs.getString(3));
                p.setTitre(rs.getString(4));

                e.setTitre(rs.getString("titre_evenement"));
                e.setTitre(rs.getString("secteur"));
                e.setDescription(rs.getString("description"));
                e.setBudget(rs.getFloat("budget"));
                e.setDateDebut(rs.getDate("date_debut"));
                e.setDuree(rs.getInt("duree"));

                f.setId(rs.getString("id_user"));
                f.setNom(rs.getString("nom"));
                f.setPrenom(rs.getString("prenom"));
                f.setPassword(rs.getString("password"));
                f.setEmail(rs.getString("email"));
                f.setAddresse(rs.getString("addresse"));
                f.setTelephone(rs.getString("tel"));
                f.setSecteur(rs.getString("secteur"));
                f.setCompletion_rate(rs.getInt("completion_rate"));

                l.setTitre(rs.getString("titre_livrable"));
                l.setType(rs.getString("type"));

                p.setEvenement(e);
                p.setFreelancer(f);
                p.setLivrable(l);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Participation getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Participation> getAll() {
        List<Participation> list = new ArrayList<>();
        String readAllQry = "select * from participation";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(readAllQry);
            while (rs.next()) {
                list.add(new Participation(rs.getString("titre_participation"), rs.getString("description")));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Participation> getAllByEvenement(int ide) {
        List<Participation> list = new ArrayList<>();
        String readAllQry = "select * from participation where id_evenement = ?";
        try {
            pstmt = connection.prepareStatement(readAllQry);
            pstmt.setInt(1, ide);
            rs = pstmt.executeQuery(readAllQry);

            while (rs.next()) {
                list.add(new Participation(rs.getString("titre_participation"), rs.getString("description")));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EvenementService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
