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
public class ProdutosController implements Initializable {

    @FXML
    private Button buttonComprarProduto;

    @FXML
    private TableColumn<?, ?> idColumnProduto;

    @FXML
    private TableColumn<?, ?> produtoColumnProduto;

    @FXML
    private TextField textFieldIdProduto;

    @FXML
    private TableColumn<?, ?> valorColumnProduto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Add initialization logic here
    }

}