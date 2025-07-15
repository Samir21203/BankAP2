package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import model.contas.Conta;
import model.contas.ContaCorrente;
import model.contas.ContaPoupanca;

public class ContaController implements Initializable {

    @FXML
    private Button buttonDeleteConta;

    @FXML
    private Button buttonNewConta;

    @FXML
    private Button buttonSaveConta;

    @FXML
    private TableColumn<Conta, Integer> idColumnConta;

    @FXML
    private TableColumn<Conta, String> contaColumnConta;

    @FXML
    private TableColumn<Conta, String> tipoColumnConta;

    @FXML
    private TextField textFieldCliente;

    @FXML
    private ComboBox<String> comboBoxTipoConta;

    @FXML
    private TableView<Conta> tableViewConta;

    private ObservableList<Conta> listaContas;
    private Conta contaSelecionada = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaContas = FXCollections.observableArrayList();

        idColumnConta.setCellValueFactory(new PropertyValueFactory<>("numeroConta"));
        contaColumnConta.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        tipoColumnConta.setCellValueFactory(new PropertyValueFactory<>("tipo")); // getter personalizado

        tableViewConta.setItems(listaContas);

        comboBoxTipoConta.getItems().addAll("Conta Corrente", "Conta Poupança");
        comboBoxTipoConta.getSelectionModel().selectFirst();

        tableViewConta.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                contaSelecionada = newSel;
                textFieldCliente.setText(contaSelecionada.getCliente());
                comboBoxTipoConta.setValue(contaSelecionada.getTipo());
            }
        });
    }

    @FXML
    private void handleSaveConta(ActionEvent event) {
        String cliente = textFieldCliente.getText().trim();
        String tipo = comboBoxTipoConta.getValue();

        if (cliente.isEmpty()) {
            System.out.println("Nome do cliente não pode ser vazio.");
            return;
        }

        if (contaSelecionada == null) {
            Conta novaConta;

            if (tipo.equals("Conta Corrente")) {
                novaConta = new ContaCorrente(cliente, 1000.0, 12.0); // valores padrão
            } else {
                novaConta = new ContaPoupanca(cliente, 0.02, 5); // valores padrão
            }

            listaContas.add(novaConta);
            System.out.println("Nova conta criada: " + cliente + " [" + tipo + "]");
        } else {
            contaSelecionada.setCliente(cliente);
            System.out.println("Conta atualizada: " + cliente);
            tableViewConta.refresh();
        }

        clearForm();
    }

    @FXML
    private void handleNewConta(ActionEvent event) {
        clearForm();
    }

    @FXML
    private void handleDeleteConta(ActionEvent event) {
        Conta conta = tableViewConta.getSelectionModel().getSelectedItem();
        if (conta != null) {
            listaContas.remove(conta);
            System.out.println("Conta removida: " + conta.getCliente());
            clearForm();
        } else {
            System.out.println("Nenhuma conta selecionada.");
        }
    }

    private void clearForm() {
        textFieldCliente.clear();
        comboBoxTipoConta.getSelectionModel().selectFirst();
        tableViewConta.getSelectionModel().clearSelection();
        contaSelecionada = null;
    }
}