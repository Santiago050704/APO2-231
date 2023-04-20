package com.example.intro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Label miLabel;

    @FXML
    private Button button;

    @FXML
    private TextField textField;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Eventos
        button.setOnAction(actionEvent -> {
            String texto = textField.getText();
            System.out.println(texto);
            miLabel.setText(texto);
        });
    }
}