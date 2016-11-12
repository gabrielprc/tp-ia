package test;

import main.java.model.beans.Patient;
import main.java.model.beans.Prediction;
import main.java.model.beans.RiskFactor;
import main.java.model.beans.Symptom;
import main.java.model.clips.SoeEnvironment;
import main.java.model.constants.RiskFactorType;
import main.java.model.constants.SymptomType;
import net.sf.clipsrules.jni.*;

import java.util.List;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public class SoeEnvironmentTest {

    public static void main(String[] args) {
        try {
            SoeEnvironment soe = new SoeEnvironment();
            Symptom symptom = new Symptom("Frio", SymptomType.SENSITIVITY);
            soe.assertSymptom(symptom);
            soe.assertSymptom(new Symptom("Bruxismo", SymptomType.INFLAMATION));
            RiskFactor riskFactor = new RiskFactor("Obesidad", RiskFactorType.DISEASE);
            soe.assertRiskFactor(riskFactor);
            soe.run();

            Patient patient = new Patient();
            patient.setName("TestPatient");
            List<Prediction> predictions = soe.getPredictions(patient);

            for (Prediction prediction : predictions) {
                System.out.println(String.format("%s: %s - %s (from '%s')",
                        prediction.getPatient().getName(),
                        prediction.getAffection().getName(),
                        prediction.getProbability().getLabel(),
                        prediction.getJustification()));
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            System.out.println(System.getProperty("java.library.path"));
        } finally {
            System.exit(1);
        }
    }

}
