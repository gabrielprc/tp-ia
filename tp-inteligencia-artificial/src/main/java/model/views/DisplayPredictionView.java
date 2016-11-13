package main.java.model.views;

import javafx.beans.property.SimpleStringProperty;

public class DisplayPredictionView {

    private SimpleStringProperty affection;
    private SimpleStringProperty probability;
    private SimpleStringProperty justification;

    public DisplayPredictionView(String affection, String probability, String justification) {
        this.affection = new SimpleStringProperty(affection);
        this.probability = new SimpleStringProperty(probability);
        this.justification = new SimpleStringProperty(justification);
    }


    public String getAffection() {
        return affection.get();
    }

    public void setAffection(SimpleStringProperty affection) {
        this.affection = affection;
    }

    public String getProbability() {
        return probability.get();
    }

    public void setProbability(SimpleStringProperty probability) {
        this.probability = probability;
    }

    public String getJustification() {
        return justification.get();
    }

    public void setJustification(SimpleStringProperty justification) {
        this.justification = justification;
    }
}
