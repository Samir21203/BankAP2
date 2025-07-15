package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Produto;

public class ProdutosController implements Initializable {

    // --- Elementos FXML injetados da tela ---
    @FXML
    private Button buttonComprarProduto;
    @FXML
    private TextField textFieldIdProduto;
    @FXML
    private TableView<Produto> produtoTable;
    @FXML
    private TableColumn<Produto, Integer> idColumnProduto;
    @FXML
    private TableColumn<Produto, String> produtoColumnProduto;
    @FXML
    private TableColumn<Produto, Double> valorColumnProduto;
    
    // Lista de dados para popular a tabela.
    private ObservableList<Produto> listaProdutos;

    // Método executado ao iniciar a tela.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Associa as colunas da tabela às propriedades da classe Produto.
        idColumnProduto.setCellValueFactory(new PropertyValueFactory<>("id"));
        produtoColumnProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        valorColumnProduto.setCellValueFactory(new PropertyValueFactory<>("valor"));

        // Carrega os dados na tabela.
        carregarDadosTabela();
    }
    
    // Ação executada ao clicar no botão "Comprar".
    @FXML
    private void handleComprarProdutoButton(ActionEvent event) {
        // Lê o texto do campo de ID.
        String idProdutoTexto = textFieldIdProduto.getText();
        
        // Verifica se o campo de texto não está vazio.
        if (idProdutoTexto == null || idProdutoTexto.trim().isEmpty()) {
            exibirAlerta("Erro", "O campo ID do produto não pode estar vazio.");
            return;
        }

        try {
            // Converte o texto para um número inteiro.
            int idProduto = Integer.parseInt(idProdutoTexto);
            
            // TODO: Implementar a lógica real de compra aqui.
            System.out.println("Produto com ID " + idProduto + " comprado.");
            
            // Exibe mensagem de sucesso.
            exibirAlerta("Sucesso", "Compra realizada!");
            textFieldIdProduto.clear();

        } catch (NumberFormatException e) {
            // Exibe erro se o ID não for um número.
            exibirAlerta("Erro", "Por favor, insira um ID numérico válido.");
        }
    }

    // Preenche a tabela com dados de exemplo.
    private void carregarDadosTabela() {
        // Cria uma lista de produtos (em um app real, viria de um banco de dados).
        listaProdutos = FXCollections.observableArrayList(
            new Produto(1, "Notebook Gamer", 7500.00),
            new Produto(2, "Mouse sem fio", 150.50),
            new Produto(3, "Teclado Mecânico", 350.75)
        );
        
        // Conecta a lista de dados à tabela.
        produtoTable.setItems(listaProdutos);
    }
    
    // Método auxiliar para mostrar um pop-up de alerta.
    private void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}