package main.java.model.clips;

import main.java.model.beans.RiskFactor;
import main.java.model.beans.Symptom;
import main.java.model.constants.SymptomType;
import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.PrimitiveValue;

/**
 * Created by alvaro.daniel.calace on 11/12/2016.
 */
public class SoeEnvironment extends Environment {

    public SoeEnvironment() {
        super();
        super.loadFromResource("/main/clips/templates.clp");
        super.loadFromResource("/main/clips/rules.clp");
        super.loadFromResource("/main/clips/functions.clp");
    }

    public PrimitiveValue assertSymptom(Symptom symptom) {
        return super.assertString(String.format("(Sintoma (%s \"%s\"))", symptom.getType().label, symptom.getName()));
    }

    public PrimitiveValue assertRiskFactor(RiskFactor riskFactor) {
        return super.assertString(String.format("(FactorDeRiesgo (%s \"%s\"))",
                riskFactor.getType().label, riskFactor.getName()));
    }
}
