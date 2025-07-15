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
public class ContaController implements Initializable {

    @FXML
    private Button buttonDeleteConta;

    @FXML
    private Button buttonNewConta;

    @FXML
    private Button buttonSaveConta;

    @FXML
    private TableColumn<?, ?> contaColumnConta;

    @FXML
    private TableColumn<?, ?> idColumnConta;

    @FXML
    private TextField texteFieldConta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Add initialization logic here
    }

}
```