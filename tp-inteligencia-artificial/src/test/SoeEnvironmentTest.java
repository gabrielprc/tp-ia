package test;

import main.java.model.beans.Prediction;
import main.java.model.beans.RiskFactor;
import main.java.model.beans.Symptom;
import main.java.model.clips.SoeEnvironment;
import main.java.model.constants.RiskFactorType;
import main.java.model.constants.SymptomType;
import net.sf.clipsrules.jni.*;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public class SoeEnvironmentTest {

    public static void main(String[] args) {
        try {
            SoeEnvironment soe = new SoeEnvironment();

            Symptom symptom = new Symptom("Frio", SymptomType.SENSITIVITY);
            soe.assertSymptom(symptom);
            RiskFactor riskFactor = new RiskFactor("Obesidad", RiskFactorType.DISEASE);
            soe.assertRiskFactor(riskFactor);
            soe.run();

            MultifieldValue pv = (MultifieldValue) soe.eval("(get-presuncion-list)");

            for (int i = 0; i < pv.size(); i++) {
                FactAddressValue fv = (FactAddressValue) pv.get(i);
                String trastorno = ((StringValue) fv.getFactSlot("PosibleTrastorno")).stringValue();
                String probabilidad = ((StringValue) fv.getFactSlot("Probabilidad")).stringValue();
                System.out.println(trastorno + " - " + probabilidad);
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            System.out.println(System.getProperty("java.library.path"));
        } finally {
            System.exit(1);
        }
    }

}
