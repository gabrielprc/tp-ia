package main.java.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for the second vista.
 */
public class CreatePredictionController {


    private List<String> symptoms = new ArrayList<String>();

    private List<String> riskFactors = new ArrayList<String>();

    @FXML
    private HBox sintomasHBox, factoresDeRiesgoHBox;

    @FXML
    private VBox dolorVBox, habitosVBox, inflamacionVBox;

    @FXML
    private VBox enfermedadesVBox, saludVBox, sensibilidadVBox;

    @FXML
    private Button ButtonPredict;

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

        System.out.println(symptoms);
        System.out.println(riskFactors);
    }

}