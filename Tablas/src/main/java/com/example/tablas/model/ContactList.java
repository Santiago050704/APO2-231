package com.example.tablas.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactList {

    //Globales
    private ObservableList<Contact> contacts = FXCollections.observableArrayList();

    //Constructor privado
    public ObservableList<Contact> getContacts(){
        return contacts;
    }

    public void setContacts(ObservableList<Contact> contacts) {
        this.contacts = contacts;
    }

    private ContactList(){

    }

    private static ContactList instance = null;

    public static ContactList getInstance(){
        if(instance == null){
            instance = new ContactList();
        }
        return instance;
    }



}
