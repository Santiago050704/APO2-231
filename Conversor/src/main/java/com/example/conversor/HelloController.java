package com.example.conversor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ComboBox<String> optionsCB;

    @FXML
    private MenuItem closeBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Button convertBtn;

    @FXML
    private TextField valueTF;

    @FXML
    private TextArea outputTA;

    @FXML
    public void save(ActionEvent e){

    }

    @FXML
    public void convert(ActionEvent e){
        //COP a USD
        try{
            String opt = optionsCB.getValue();
            //optionsCB.getSelectionModel().getSelectedItem();
            switch (opt){
                case "COP a USD":
                    double value = Double.parseDouble(valueTF.getText());
                    double result = value/4500;
                    outputTA.setText(result + " US$");
                    break;

                case "USD a COP":
                    double value1 = Double.parseDouble(valueTF.getText());
                    double result1 = value1*4500;
                    outputTA.setText(result1 + " COP");
                    break;
            }
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Lo que ha ingresado NO es un número válido");
            alert.showAndWait();

            ex.printStackTrace();
        }

    }

    @FXML
    public void close(ActionEvent e){
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Condiciones iniciales
        ObservableList olist = FXCollections.observableArrayList();
        olist.add("COP a USD");
        olist.add("USD a COP");
        optionsCB.setItems(olist);
        optionsCB.setPromptText("Elija una conversion");

        optionsCB.getSelectionModel().selectedItemProperty().addListener((value, old, nu)->{
            /*System.out.println(old);
            System.out.println(nu);*/
            outputTA.setText("");
            valueTF.setText("");
        });
    }

    @FXML
    public void testButton(ActionEvent event){
        Button source = (Button)event.getSource();
        System.out.println("Hola from " + source.getText());
    }
}