package main.java.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import main.java.model.beans.Patient;
import main.java.model.dao.PatientDao;

public class CreatePatientController {

    @FXML
    private TextField name;

    public void createPatient() {
        PatientDao patientDao = new PatientDao();
        Patient patient = new Patient();
        patient.setName(name.getText());
        patientDao.save(patient);
        name.setText("");
    }

}