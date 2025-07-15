/*
 * FXML Controller class
 *
 * 
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
     * Lida com o evento de clique no botão de login.
     * @param event O evento de ação gerado pelo clique.
     */
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        // Pega o texto dos campos de usuário e senha
        String username = userFieldLogin.getText();
        String password = passwordFieldLogin.getText();

        // Verifica se os campos não estão vazios
        if (username.isBlank() || password.isBlank()) {
            invalidLloginLabel.setText("Por favor, preencha todos os campos.");
            invalidLloginLabel.setVisible(true);
            return; // Interrompe a execução do método
        }

        // Simula a validação do login
        if (username.equals("admim") && password.equals("12345")) {
            invalidLloginLabel.setVisible(false);
            System.out.println("Login bem-sucedido!");
            
            // Tenta carregar a nova janela (ex: a tela principal do sistema)
            try {
                // Carrega o arquivo FXML da próxima tela
                // Certifique-se de que "MainView.fxml" existe no seu projeto
                Parent root = FXMLLoader.load(getClass().getResource("principal.fxml")); 
                
                Stage stage = new Stage();
                stage.setTitle("Tela Principal");
                stage.setScene(new Scene(root));
                
                // Mostra a nova janela
                stage.show();
                
                // Fecha a janela de login atual
                Stage currentStage = (Stage) buttonLogin.getScene().getWindow();
                currentStage.close();

            } catch (IOException e) {
                e.printStackTrace();
                invalidLloginLabel.setText("Erro ao carregar a próxima tela.");
                invalidLloginLabel.setVisible(true);
            }

        } else {
            // Se o login for inválido, mostra a mensagem de erro
            invalidLloginLabel.setText("Usuário ou senha inválidos!");
            invalidLloginLabel.setVisible(true);
        }
    }
    
    /**
     * Inicializa a classe do controlador.
     * Este método é chamado automaticamente após o carregamento do arquivo FXML.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Esconde a label de login inválido no início
        invalidLloginLabel.setVisible(false);
    }   
}