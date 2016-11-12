package test.rules;

import java.util.ArrayList;
import java.util.List;

import main.java.model.beans.Patient;
import main.java.model.beans.RiskFactor;
import main.java.model.beans.Symptom;
import main.java.model.constants.SymptomType;
import main.java.model.dao.DaoQuery;
import main.java.model.dao.SymptomDao;

public class RuleTest_1 {

	public static void main(String[] args) {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		List<RiskFactor> riskFactors = new ArrayList<RiskFactor>();
		
		DaoQuery symptomQuery = new DaoQuery.Builder()
			.type(SymptomType.SENSITIVITY.type)
			.name("Frio")
		.build();
		
		symptoms = new SymptomDao().list(symptomQuery);
		
		Patient patient = new Patient("Juan Perez", symptoms, riskFactors);
		
		RuleTest test = new RuleTest(patient);
		
		test.run();
	}

}
