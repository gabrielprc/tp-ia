package main.java.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.model.beans.Patient;
import main.java.model.beans.Prediction;
import main.java.model.beans.RiskFactor;
import main.java.model.beans.Symptom;
import main.java.model.clips.AppEnvironment;
import main.java.model.dao.DaoQuery;
import main.java.model.dao.PatientDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatePredictionController {

    private AppEnvironment env = new AppEnvironment();

    private List<String> symptoms = new ArrayList<String>();

    private List<String> riskFactors = new ArrayList<String>();

    private PatientDao patientDao;

    @FXML
    private HBox sintomasHBox, factoresDeRiesgoHBox;

    @FXML
    private Button ButtonPredict;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private void initialize() {

        patientDao = new PatientDao();
        List<Patient> patients = patientDao.list();
        ObservableList<String> patientsNames =
                FXCollections.observableArrayList();

        for (Patient p : patients) {
            patientsNames.add(p.getName());
        }
        comboBox.setItems(patientsNames);
    }

    @FXML
    public void predict(ActionEvent event) {

        for (int i = 0; i < sintomasHBox.getChildren().size(); i++) {
            VBox sintomas = (VBox) sintomasHBox.getChildren().get(i);
            for (int j = 0; j < sintomas.getChildren().size(); j++) {
                Node checkBox = sintomas.getChildren().get(j);
                if (checkBox instanceof CheckBox) {
                    CheckBox cb = (CheckBox) checkBox;
                    if (cb.isSelected()) symptoms.add(cb.getText());
                }
            }
        }
        for (int l = 0; l < factoresDeRiesgoHBox.getChildren().size(); l++) {
            VBox riskFactor = (VBox) factoresDeRiesgoHBox.getChildren().get(l);
            for (int m = 0; m < riskFactor.getChildren().size(); m++) {
                Node checkBox = riskFactor.getChildren().get(m);
                if (checkBox instanceof CheckBox) {
                    CheckBox cb = (CheckBox) checkBox;
                    if (cb.isSelected()) riskFactors.add(cb.getText());
                }
            }
        }

        Patient patient = patientDao.list(new DaoQuery.Builder().name(comboBox.getValue()).build()).get(0);
        patient.setSymptoms(symptoms.stream().map(s -> new Symptom(s)).collect(Collectors.toList()));
        patient.setRiskFactors(riskFactors.stream().map(r -> new RiskFactor(r)).collect(Collectors.toList()));

        patientDao.save(patient);

        env.assertSymptoms(patient.getSymptoms());
        env.assertRiskFactors(patient.getRiskFactors());
        env.run();

        openPredictionResultsWindow(env.getPredictions(patient));
    }

    public void openPredictionResultsWindow(List<Prediction> predictions) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(VistaNavigator.DISPLAY_PREDICTIONS_VIEW));

        Parent root;
        try {
            root = (Parent) loader.load();
            Scene scene = new Scene(root, 800, 600);
            Stage stage = new Stage();
            stage.setScene(scene);
            DisplayPredictionController controller = loader.getController();
            loader.setController(controller);
            loader.setRoot(controller);
            controller.initData(comboBox.getSelectionModel().getSelectedItem(), predictions);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DisplayPredictionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}