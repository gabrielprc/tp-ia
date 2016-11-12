package main.java.model.clips;

import main.java.model.beans.*;
import main.java.model.constants.AffectionType;
import main.java.model.constants.Probability;
import main.java.model.constants.SymptomType;
import net.sf.clipsrules.jni.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public class AppEnvironment extends Environment {

    public AppEnvironment() {
        super();
        super.loadFromResource("/main/clips/templates.clp");
        super.loadFromResource("/main/clips/rules.clp");
        super.loadFromResource("/main/clips/functions.clp");
    }

    public PrimitiveValue assertSymptom(Symptom symptom) {
        return super.assertString(String.format("(Sintoma (%s \"%s\"))", symptom.getType().label, symptom.getName()));
    }

    public List<PrimitiveValue> assertSymptoms(List<String> symptoms) {
        List<PrimitiveValue> values = new ArrayList<>();
        symptoms.forEach(s -> values.add(this.assertSymptom(new Symptom(s, TypeMapper.getSymptomType(s)))));
        return values;
    }

    public List<PrimitiveValue> assertRiskFactors(List<String> riskFactors) {
        List<PrimitiveValue> values = new ArrayList<>();
        riskFactors.forEach(r -> values.add(this.assertRiskFactor(new RiskFactor(r, TypeMapper.getRiskFactorType(r)))));
        return values;
    }

    public PrimitiveValue assertRiskFactor(RiskFactor riskFactor) {
        return super.assertString(String.format("(FactorDeRiesgo (%s \"%s\"))",
                riskFactor.getType().label, riskFactor.getName()));
    }

    public List<Prediction> getPredictions(Patient patient) {
        List<Prediction> predictions = new ArrayList<>();
        MultifieldValue facts = (MultifieldValue) super.eval("(get-presuncion-list)");

        for (int i = 0; i < facts.size(); i++) {
            FactAddressValue fact = (FactAddressValue) facts.get(i);
            String affectionName = getStringFromSlot(fact, "PosibleTrastorno");
            Affection affection = new Affection(TypeMapper.getAffectionType(affectionName), affectionName);
            Probability probability = Probability.getByLabel(getStringFromSlot(fact, "Probabilidad"));
            String justification = getStringFromSlot(fact, "Justificacion");
            predictions.add(new Prediction(patient, affection, probability, justification));
        }

        return predictions;
    }

    private String getStringFromSlot(FactAddressValue fact, String slot) {
        try {
            return ((StringValue) fact.getFactSlot(slot)).stringValue();
        } catch (Exception e) {
            return null;
        }
    }
}