/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import smartstart.model.Evenement;
import smartstart.model.Freelance;
import smartstart.model.Participation;
import smartstart.service.ParticipationService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterParticipationController implements Initializable {

    @FXML
    private TextField titretxt;
    @FXML
    private TextArea desctxt;
    @FXML
    private Button livbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ParticipationService es = new ParticipationService();
        Freelance f = new Freelance();
        f.setId("dqfsgdh");
        livbtn.setOnAction(evt -> {
            if (!titretxt.getText().isEmpty() && !desctxt.getText().isEmpty()) {
            Participation p = new Participation();
            p.setTitre(titretxt.getText());
            p.setDescription(desctxt.getText());
            p.setFreelancer(f);
            es.add(p);
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("Livrable.fxml"));
                livbtn.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }});
    }    
    
}
