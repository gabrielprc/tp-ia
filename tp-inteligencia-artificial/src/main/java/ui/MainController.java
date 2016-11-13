package main.java.ui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;


public class MainController {

    @FXML
    private StackPane vistaHolder;

    public void setVista(Node node) {
        vistaHolder.getChildren().setAll(node);
    }

    public void showCreatePatientView() {
        VistaNavigator.loadVista(VistaNavigator.CREATE_PATIENT_VIEW);
    }

    public void showDiagnoseView() {
        VistaNavigator.loadVista(VistaNavigator.CREATE_PREDICTION_VIEW);
    }

}