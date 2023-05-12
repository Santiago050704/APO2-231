package com.example.tablas;

import com.example.tablas.model.Contact;
import com.example.tablas.model.ContactList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TableView<Contact> contactTable;

    @FXML
    private TableColumn<Contact, String> nameTC;

    @FXML
    private TableColumn<Contact, String> lastnameTC;

    @FXML
    private TableColumn<Contact, Integer> phoneTC;

    @FXML
    private Button addBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastnameTC.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        phoneTC.setCellValueFactory(new PropertyValueFactory<>("phone"));

        contactTable.setItems(
                ContactList.getInstance().getContacts()
        );

        addBtn.setOnAction(action->{
            HelloApplication.openWindow("form.fxml");
        });
    }

}