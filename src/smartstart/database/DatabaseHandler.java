/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class DatabaseHandler {

    private String url = "jdbc:mysql://localhost:3306/smartstartt";
    private String username = "root";
    private String password = "";
    private Connection connection;
    private static DatabaseHandler instance;

    private DatabaseHandler() {
        try {
            // TODO code application logic here
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static DatabaseHandler getInstance(){
        if(instance==null)
            instance=new DatabaseHandler();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
