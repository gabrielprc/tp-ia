package main.java.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreatePatientController {

    @FXML
    private TextField name;

    public void createPatient() {
        System.out.println(name.getText());
    }

}