package com.example.tablas.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactList {

    //Globales
    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    //Constructor privado
    private ContactList(){

    }

    private static ContactList instance = null;

    public static ContactList getInstance(){
        if(instance == null){
            instance = new ContactList();
        }
        return instance;
    }

    public ObservableList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ObservableList<Contact> contacts) {
        this.contacts = contacts;
    }
}
