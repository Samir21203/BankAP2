package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 
 */
public class ClienteController implements Initializable {

    @FXML
    private Button buttonDeleteCliente;

    @FXML
    private Button buttonNewCliente;

    @FXML
    private Button buttonSaveCliente;

    @FXML
    private TableColumn<?, ?> clienteColumnCliente;

    @FXML
    private TableColumn<?, ?> idColumnCliente;

    @FXML
    private TextField textFieldCliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Add initialization logic here
    }

}