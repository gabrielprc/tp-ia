package main.java.ui;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class VistaNavigator {

    public static final String MAIN = "/main/java/ui/fxml/main.fxml";
    public static final String CREATE_PATIENT_VIEW = "/main/java/ui/fxml/createPatientView.fxml";
    public static final String CREATE_PREDICTION_VIEW = "/main/java/ui/fxml/createPredictionView.fxml";
    public static final String DISPLAY_PREDICTIONS_VIEW = "/main/java/ui/fxml/displayPredictionView.fxml";

    private static MainController mainController;

    public static void setMainController(MainController mainController) {
        VistaNavigator.mainController = mainController;
    }
    
    public static void loadVista(String fxml) {
        try {
            mainController.setVista(
                    FXMLLoader.load(
                            VistaNavigator.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}