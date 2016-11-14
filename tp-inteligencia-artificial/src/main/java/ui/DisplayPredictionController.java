package main.java.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import main.java.model.beans.Prediction;
import main.java.model.views.DisplayPredictionView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DisplayPredictionController implements Initializable{

    @FXML
    private Label textLabel, patientLabel;

    @FXML
    private TableColumn<DisplayPredictionView, String> affectionColumn, probabilityColumn, justificationColumn;

    @FXML
    private TableView<DisplayPredictionView> resultTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void initData(String patient, List<Prediction> predictions) {

        List<DisplayPredictionView> predictionViews = new ArrayList<DisplayPredictionView>();

        textLabel.setText("Diagnóstico para el paciente ");
        patientLabel.setText(patient);

        for(Prediction p : predictions) {
            predictionViews.add(new DisplayPredictionView(
                    p.getAffection().getName(),
                    p.getProbability().getLabel(),
                    p.getJustification())
            );
        }

        affectionColumn.setCellValueFactory(new PropertyValueFactory<>("affection"));
        probabilityColumn.setCellValueFactory(new PropertyValueFactory<>("probability"));
        justificationColumn.setCellValueFactory(new PropertyValueFactory<>("justification"));

        ObservableList<DisplayPredictionView> data =
                FXCollections.observableArrayList(predictionViews);

        resultTable.setItems(data);

        resultTable.setRowFactory(row -> new TableRow<DisplayPredictionView>(){
            public void updateItem(DisplayPredictionView item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setStyle("");
                } else {
                    if (item.getProbability().equals("Muy alta")) {
                        setStyle("-fx-background-color: #EF9A9A");
                    }
                    else if (item.getProbability().equals("Alta")) {
                        setStyle("-fx-background-color: #FFCC80");
                    } else if (item.getProbability().equals("Media")) {
                        setStyle("-fx-background-color: #FFF59D");
                    } else if (item.getProbability().equals("Baja")) {
                        setStyle("-fx-background-color: #C5E1A5");
                    }
                }
            }
        });
    }
}


