/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import smartstart.model.Evenement;
import smartstart.model.JobOwner;
import smartstart.service.EvenementService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterEvenementController implements Initializable {

    @FXML
    private TextField titretxt;
    @FXML
    private TextField budgettxt;
    @FXML
    private TextArea desctxt;
    @FXML
    private ComboBox<String> secteurcmb;
    @FXML
    private DatePicker datedebutpicker;
    @FXML
    private TextField dureetxt;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        budgettxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,5}([\\.]\\d{0,3})?")) {
                    budgettxt.setText(oldValue);
                }
            }
        });
        dureetxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,2}")) {
                    dureetxt.setText(oldValue);
                }
            }
        });
        secteurcmb = new ComboBox<>();
        secteurcmb.getItems().addAll(
                "Devloppement Web",
                "Devloppement Mobile",
                "Software Developpment",
                "Graphic Design"
        );
        
        EvenementService es = new EvenementService();
        JobOwner jo = new JobOwner();
        jo.setId("test");
        btn.setOnAction(evt -> {
            if (!titretxt.getText().isEmpty() && !secteurcmb.getValue().isEmpty() && !desctxt.getText().isEmpty() && !budgettxt.getText().isEmpty()
                && !datedebutpicker.getValue().isBefore(new java.sql.Date(System.currentTimeMillis()).toLocalDate()) && !dureetxt.getText().isEmpty()) {
            //labNotif.setVisible(true);
            
            //labNotif.setTextFill(Color.TOMATO);
            //labNotif.setText("tous les champs doivent être remplis");
            Evenement e = new Evenement();
            //e = new Evenement(titretxt.getText(), secteurcmb.getValue(), desctxt.getText(), Integer.parseInt(budgettxt.getText()), Date.valueOf(datedebutpicker.getValue()), Integer.parseInt(dureetxt.getText()));
            e.setTitre(titretxt.getText());
            e.setSecteur(secteurcmb.getValue());
            e.setDescription(desctxt.getText());
            e.setBudget(Float.parseFloat(budgettxt.getText()));
            e.setDateDebut(Date.valueOf(datedebutpicker.getValue()));
            e.setDuree(Integer.parseInt(dureetxt.getText()));
            e.setJobOwner(jo);
            es.add(e);
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("AfficherEvenements.fxml"));
                btn.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }});
    }

}
