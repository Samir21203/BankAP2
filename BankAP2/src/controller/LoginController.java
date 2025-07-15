/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class LoginController implements Initializable {
@FXML
    private Button buttonLogin;

    @FXML
    private Label invalidLloginLabel;

    @FXML
    private AnchorPane leftLoginPane;

    @FXML
    private BorderPane loginPane;

    @FXML
    private PasswordField passwordField;

    @FXML
    private AnchorPane rightLoginPane;

    @FXML
    private TextField userField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
}



   
