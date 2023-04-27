package com.example.conversor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField emailTF;

    @FXML
    private TextField passwordTF;

    @FXML
    public void login(ActionEvent event){
        String email = emailTF.getText();
        String password = passwordTF.getText();

        if(email.equals("admin") && password.equals("pass")){
            HelloApplication.openWindow("hello-view.fxml");
        }
    }

}
