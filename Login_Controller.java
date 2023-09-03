package com.example.file_flow;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;


public class Login_Controller {
    @FXML
    private Label welcomeText;

    @FXML
    private Button Cancel_Button;

    @FXML
    private Label loginmessagewarning;

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    public void login_message_warning()
    {
        loginmessagewarning.setText("Checking...");

        if (usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false)
        {
            loginmessagewarning.setText("Checking...");
        }
        else
        {
            loginmessagewarning.setText("Please Check Your Username And Password.");
        }
    }

    public void cancel_button_on_action(ActionEvent e)
    {
        Stage stage = (Stage) Cancel_Button.getScene().getWindow();
        stage.close();
    }
}
