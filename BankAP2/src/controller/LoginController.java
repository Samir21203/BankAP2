/*
 * FXML Controller class
 *
 * 
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoginController implements Initializable {

   @FXML
    private Button buttonLogin;

    @FXML
    private Label invalidLloginLabel;

    @FXML
    private Label labelForgotPassword;

    @FXML
    private AnchorPane leftLoginPane;

    @FXML
    private BorderPane loginPane;

    @FXML
    private PasswordField passwordFieldLogin;

    @FXML
    private AnchorPane rightLoginPane;

    @FXML
    private TextField userFieldLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}