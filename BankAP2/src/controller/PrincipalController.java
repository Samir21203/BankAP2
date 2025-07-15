package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author 
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button buttonClientesPrincipal;

    @FXML
    private Button buttonContasPrincipal;

    @FXML
    private Button buttonProdutosPrincipal;

    @FXML
    private TableView<?> clienteTablePrincipal;

    @FXML
    private TableColumn<?, ?> clientesColumnPrincipal;

    @FXML
    private TableColumn<?, ?> contaColumnprincipal;

    @FXML
    private TableView<?> contaTablePrincipal;

    @FXML
    private TableColumn<?, ?> cpfClienteColumnPrincipal;

    @FXML
    private TableColumn<?, ?> emailColumnContaPrincipal;

    @FXML
    private TableColumn<?, ?> idClienteColumnPrincipal;

    @FXML
    private TableColumn<?, ?> idColumnContarincipal;

    @FXML
    private TableColumn<?, ?> idColumnProdutosPrincipal;

    @FXML
    private TableColumn<?, ?> precoColumnProdutoPrincipal;

    @FXML
    private BorderPane principalBorderPane;

    @FXML
    private TableView<?> produtoTablePrincipal;

    @FXML
    private TableColumn<?, ?> produtosColumnPrincipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Add initialization logic here
    }

}
```