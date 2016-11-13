package main.java.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

        textLabel.setText("El diagnóstico para el paciente:");
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
    }
}


