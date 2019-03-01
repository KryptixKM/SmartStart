/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import smartstart.model.Evenement;
import smartstart.service.EvenementService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherEvenementsController implements Initializable {

    @FXML
    private TableView<Evenement> eventtable;
    @FXML
    private TableColumn<Evenement, String> titrecol;
    @FXML
    private TableColumn<Evenement, String> secteurcol;
    @FXML
    private TableColumn<Evenement, String> desccol;
    @FXML
    private TableColumn<Evenement, Float> budgetcol;
    @FXML
    private TableColumn<Evenement, Date> datedebutcol;
    @FXML
    private TableColumn<Evenement, Integer> dureecol;
    @FXML
    private TableColumn<Evenement, Button> modifcol;
    @FXML
    private TableColumn<Evenement, Button> suppcol;
    
    private Evenement evt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        EvenementService es = new EvenementService();
        ArrayList<Evenement> list = (ArrayList<Evenement>) es.getEvenementsOfJobOwner("test");

        ObservableList<Evenement> obs = FXCollections.observableArrayList(list);
        eventtable.setItems(obs);
        titrecol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        secteurcol.setCellValueFactory(new PropertyValueFactory<>("secteur"));
        desccol.setCellValueFactory(new PropertyValueFactory<>("description"));
        budgetcol.setCellValueFactory(new PropertyValueFactory<>("budget"));
        datedebutcol.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dureecol.setCellValueFactory(new PropertyValueFactory<>("duree"));

        modifcol.setCellValueFactory(param -> {
            SimpleObjectProperty property = new SimpleObjectProperty();
            evt = (Evenement) param.getValue();
            EvenementService eserv = new EvenementService();
            Button mod = new Button("modifier");
            //rep.setStyle("-fx-background-color:#FF0000;");
            mod.setOnAction(ev -> {
                //eserv.update(evt);

                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("ModifierEvenement.fxml"));
                    mod.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AfficherEvenementsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            property.set(mod);
            return property;

        });
        
        suppcol.setCellValueFactory(param -> {
            SimpleObjectProperty property = new SimpleObjectProperty();
            Evenement evt = (Evenement) param.getValue();
            EvenementService eserv = new EvenementService();
            Button sup = new Button("supprimer");
            //rep.setStyle("-fx-background-color:#FF0000;");
            sup.setOnAction(ev -> {
                System.out.println(evt.getId());
                eserv.delete(evt);

                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("AfficherEvenements.fxml"));
                    sup.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AfficherEvenementsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            property.set(sup);
            return property;

        });

    }

    public Evenement getEvt() {
        return evt;
    }
    
    

}
