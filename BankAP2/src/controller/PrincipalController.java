package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import model.contas.Conta;
import model.produtos.ProdutoBancario;
import persistence.ClienteDAO;
import persistence.ContaDAO;
import persistence.ProdutoDAO;

/**
 * FXML Controller da tela principal.
 * Gerencia a exibição de diferentes tabelas de dados na mesma janela.
 */
public class PrincipalController implements Initializable {

    // --- Injeção dos Componentes FXML ---

    // Botões de Navegação
    @FXML private Button buttonClientesPrincipal;
    @FXML private Button buttonProdutosPrincipal;
    @FXML private Button buttonContasPrincipal;

    // Tabela de Clientes e suas colunas
    @FXML private TableView<Cliente> clienteTablePrincipal;
    @FXML private TableColumn<Cliente, Long> idClienteColumnPrincipal;
    @FXML private TableColumn<Cliente, String> cpfClienteColumnPrincipal;
    @FXML private TableColumn<Cliente, String> clientesColumnPrincipal;

    // Tabela de Contas e suas colunas
    @FXML private TableView<Conta> contaTablePrincipal;
    @FXML private TableColumn<Conta, Long> idColumnContarincipal; // Note o 'r' minúsculo
    @FXML private TableColumn<Conta, String> emailColumnContaPrincipal;
    @FXML private TableColumn<Conta, Cliente> contaColumnprincipal;

    // Tabela de Produtos e suas colunas
    @FXML private TableView<ProdutoBancario> produtoTablePrincipal;
    @FXML private TableColumn<ProdutoBancario, Long> idColumnProdutosPrincipal;
    @FXML private TableColumn<ProdutoBancario, String> precoColumnProdutoPrincipal; // Nome pode ser ajustado
    @FXML private TableColumn<ProdutoBancario, String> produtosColumnPrincipal;


    /**
     * Este método é chamado automaticamente quando o FXML é carregado.
     * É o lugar perfeito para configurar as tabelas.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configura as colunas para saberem de onde pegar os dados de cada objeto
        configurarColunas();

        // Exibe a tabela de clientes por padrão ao abrir a tela
        handleMostrarClientes(null);
    }

    private void configurarColunas() {
        // Tabela Clientes: Liga cada coluna a um atributo da classe Cliente
        idClienteColumnPrincipal.setCellValueFactory(new PropertyValueFactory<>("id"));
        cpfClienteColumnPrincipal.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        clientesColumnPrincipal.setCellValueFactory(new PropertyValueFactory<>("nome"));

        // Tabela Contas: Liga cada coluna a um atributo da classe Conta
        idColumnContarincipal.setCellValueFactory(new PropertyValueFactory<>("numeroConta"));
        emailColumnContaPrincipal.setCellValueFactory(new PropertyValueFactory<>("cliente")); // Mostra o objeto Cliente (toString)
        contaColumnprincipal.setCellValueFactory(new PropertyValueFactory<>("tipo")); // Mostra o tipo da conta
        
        // Tabela Produtos: Liga cada coluna a um atributo da interface ProdutoBancario
        idColumnProdutosPrincipal.setCellValueFactory(new PropertyValueFactory<>("codigoUnico"));
        precoColumnProdutoPrincipal.setCellValueFactory(new PropertyValueFactory<>("descricao")); // Usando a descrição como "preço"
        produtosColumnPrincipal.setCellValueFactory(new PropertyValueFactory<>("tipoProduto"));
    }

    // --- Handlers dos Botões ---

    @FXML
    private void handleMostrarClientes(ActionEvent event) {
        alternarVisibilidadeTabela(clienteTablePrincipal);
        carregarTabelaClientes();
    }

    @FXML
    private void handleMostrarContas(ActionEvent event) {
        alternarVisibilidadeTabela(contaTablePrincipal);
        carregarTabelaContas();
    }

    @FXML
    private void handleMostrarProdutos(ActionEvent event) {
        alternarVisibilidadeTabela(produtoTablePrincipal);
        carregarTabelaProdutos();
    }

    // --- Métodos de Ajuda ---

    private void carregarTabelaClientes() {
        List<Cliente> clientes = ClienteDAO.getInstance().getAll();
        ObservableList<Cliente> obsClientes = FXCollections.observableArrayList(clientes);
        clienteTablePrincipal.setItems(obsClientes);
    }

    private void carregarTabelaContas() {
        List<Conta> contas = ContaDAO.getInstance().getAll();
        ObservableList<Conta> obsContas = FXCollections.observableArrayList(contas);
        contaTablePrincipal.setItems(obsContas);
    }

    private void carregarTabelaProdutos() {
        List<ProdutoBancario> produtos = ProdutoDAO.getInstance().getAll();
        ObservableList<ProdutoBancario> obsProdutos = FXCollections.observableArrayList(produtos);
        produtoTablePrincipal.setItems(obsProdutos);
    }

    /**
     * Torna a tabela fornecida visível e esconde as outras duas.
     * @param tabelaVisivel A tabela que deve ser exibida.
     */
    private void alternarVisibilidadeTabela(TableView<?> tabelaVisivel) {
        clienteTablePrincipal.setVisible(tabelaVisivel == clienteTablePrincipal);
        contaTablePrincipal.setVisible(tabelaVisivel == contaTablePrincipal);
        produtoTablePrincipal.setVisible(tabelaVisivel == produtoTablePrincipal);
    }
}