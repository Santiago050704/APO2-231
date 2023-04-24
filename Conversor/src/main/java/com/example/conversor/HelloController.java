package com.example.conversor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ComboBox<?> optionsCB;

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
            double value = Double.parseDouble(valueTF.getText());
            double result = value/4500;
            outputTA.setText(result + " US$");
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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Condiciones iniciales
    }
}