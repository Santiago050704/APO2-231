package com.example.tablas;

import com.example.tablas.model.Contact;
import com.example.tablas.model.ContactList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterContactController {
    @FXML
    private AnchorPane containerAP;

    @FXML
    private Button createBtn;

    @FXML
    private Label createLbl;

    @FXML
    private Label lastnameLbl;

    @FXML
    private TextField lastnameTF;

    @FXML
    private Label nameLbl;

    @FXML
    private TextField nameTF;

    @FXML
    private Label phoneLbl;

    @FXML
    private TextField phoneTF;

    @FXML
    public void add(ActionEvent event){
        Contact contact = new Contact(
                nameTF.getText(),
                lastnameTF.getText(),
                Integer.parseInt(phoneTF.getText())
        );
        ContactList.getInstance().getContacts().add(contact);

        Stage stage = (Stage) createBtn.getScene().getWindow();
        stage.close(); //Se cierra la ventana.
    }

}
