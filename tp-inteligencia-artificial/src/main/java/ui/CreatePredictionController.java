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
import main.java.model.dao.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatePredictionController {

    private static final Logger logger = Logger.getLogger(CreatePredictionController.class.getName());

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
            if (comboBox.getValue() == null) {
                comboBox.setValue(p.getName());
                patientsComboBoxChange(null);
            }
        }
        comboBox.setItems(patientsNames);
    }

    @FXML
    public void patientsComboBoxChange(ActionEvent event) {
        Patient patient = getPatientFromComboBox();
        if (patient == null) {
            return;
        }
        checkByList(patient.getSymptoms(), sintomasHBox);
        checkByList(patient.getRiskFactors(), factoresDeRiesgoHBox);
    }

    //@xdddd
    private void checkByList(List<?> list, HBox hBox) {
        hBox.getChildren().forEach(vBox -> {
            ((VBox)vBox).getChildren().filtered(node -> node instanceof CheckBox).forEach(node -> {
                CheckBox checkBox = (CheckBox)node;
                checkBox.setSelected(list.stream().anyMatch(item -> {
                    String name = "";
                    try { name = (String)item.getClass().getMethod("getName").invoke(item); }
                    catch (Exception e) { logger.warning("tried to call getName on invalid item"); }
                    return name.equals(checkBox.getText());
                }));
            });
        });
    }

    private Patient getPatientFromComboBox() {
        String patientName = comboBox.getValue();
        if (patientName == null || patientName.equals("")) {
            logger.warning("tried to get patient from combobox with empty string");
            return null;
        }
        Patient patient = patientDao.getByName(patientName);
        if (patient == null) {
            logger.warning("returning null patient for name: " + patientName);
        }
        return patient;
    }

    @FXML
    public void predict(ActionEvent event) {
        Patient patient = getPatientFromComboBox();
        if (patient == null) {
            return;
        }

        symptoms.clear();
        riskFactors.clear();

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

        List<Symptom> patientSymptoms = (new SymptomDao()).getByNames(symptoms);
        patient.setSymptoms(patientSymptoms);
        if (symptoms.size() != patientSymptoms.size()) {
            logger.warning("symptoms from db do not match symptoms from view");
        }

        List<RiskFactor> patientRiskFactors = (new RiskFactorDao()).getByNames(riskFactors);
        patient.setRiskFactors(patientRiskFactors);
        if (riskFactors.size() != patientRiskFactors.size()) {
            logger.warning("riskfactors from db do not match riskfactors from view");
        }

        patientDao.save(patient);

        env.reset();
        env.assertSymptoms(patientSymptoms);
        env.assertRiskFactors(patientRiskFactors);
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