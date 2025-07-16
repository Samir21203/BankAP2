package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.produtos.ProdutoBancario;
import persistence.ProdutoDAO;
import util.TipoProduto;

public class ProdutosController implements Initializable {

    // Assumindo que seu FXML tem uma TableView com este fx:id
    @FXML
    private TableView<ProdutoBancario> tableViewProdutos;

    // Assumindo que seu FXML tem colunas com estes fx:id
    @FXML
    private TableColumn<ProdutoBancario, Long> columnId;
    @FXML
    private TableColumn<ProdutoBancario, TipoProduto> columnTipo;
    @FXML
    private TableColumn<ProdutoBancario, String> columnDescricao;
    @FXML
    private TableColumn<ProdutoBancario, String> columnCliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configura as colunas da tabela para buscar os dados da interface ProdutoBancario
        columnId.setCellValueFactory(new PropertyValueFactory<>("codigoUnico"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipoProduto"));
        columnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        columnCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));

        // Carrega os dados na tabela ao iniciar
        carregarTabelaProdutos();
    }

    private void carregarTabelaProdutos() {
        // Busca os dados do DAO
        ObservableList<ProdutoBancario> obsProdutos = FXCollections.observableArrayList(
                ProdutoDAO.getInstance().getAll()
        );
        // Popula a tabela
        tableViewProdutos.setItems(obsProdutos);
    }
}