/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import smartstart.model.Evenement;
import smartstart.service.EvenementService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherEvenementController implements Initializable {

    @FXML
    private Label titrelbl;
    @FXML
    private Label secteurlbl;
    @FXML
    private Label desclbl;
    @FXML
    private Label budgetlbl;
    @FXML
    private Label dureelbl;
    @FXML
    private Label nomlbl;
    @FXML
    private Label prenomlbl;
    @FXML
    private Label emaillbl;
    @FXML
    private Label addresslbl;
    @FXML
    private Label tellbl;
    @FXML
    private Label datedebutlbl;
    @FXML
    private Button btn;

    private Evenement e;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AfficherEvenementsFreelancerController aefcs = new AfficherEvenementsFreelancerController();
        EvenementService es = new EvenementService();
        e = new Evenement();
        e = es.getById(aefcs.getEvt().getId());
        titrelbl.setText(e.getTitre());
        secteurlbl.setText(e.getSecteur());
        desclbl.setText(e.getDescription());
        budgetlbl.setText(Float.toString(e.getBudget()));
        dureelbl.setText(Integer.toString(e.getDuree()));
        datedebutlbl.setText(e.getDateDebut().toString());
        nomlbl.setText(e.getJobOwner().getNom());
        prenomlbl.setText(e.getJobOwner().getPrenom());
        emaillbl.setText(e.getJobOwner().getEmail());
        addresslbl.setText(e.getJobOwner().getAddresse());
        tellbl.setText(e.getJobOwner().getTelephone());
        btn.setOnAction(evt -> {
            //ps.insert(new Personne(txtnom.getText(), txtprenom.getText()));
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("AjouterParticipation.fxml"));
                btn.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AfficherEvenementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public Evenement getE() {
        return e;
    }

    
}
