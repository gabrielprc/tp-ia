package main.java.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import main.java.model.beans.Prediction;

import java.util.List;

public class DisplayPredictionController {

    @FXML
    private TableView<String> resultTable;

    public void initData(String patient, List<Prediction> predictions) {
        System.out.println(patient);
    }
    public void initialize() {
        System.out.println("caca");
    }
}
