package test.rules;

import java.util.ArrayList;
import java.util.List;

import main.java.model.beans.Patient;
import main.java.model.beans.Prediction;
import main.java.model.beans.RiskFactor;
import main.java.model.beans.Symptom;
import main.java.model.clips.AppEnvironment;

public class RuleTest implements Runnable {

	List<Symptom> symptoms;
	List<RiskFactor> riskFactors;
	Patient patient;
	
	public RuleTest(Patient patient) {
		super();
		this.patient = patient;
		this.symptoms = patient.getSymptoms();
		this.riskFactors = patient.getRiskFactors();
	}

	@Override
	public void run() {
		AppEnvironment env = new AppEnvironment();
		
		for (Symptom s : symptoms) {
			env.assertSymptom(s);
		}
		
		for (RiskFactor r : riskFactors) {
			env.assertRiskFactor(r);
		}
		
		env.run();

		List<Prediction> predictions = env.getPredictions(patient);
		for (Prediction prediction : predictions) {
			System.out.println(String.format("%s: %s - %s (from '%s')",
					prediction.getPatient().getName(),
					prediction.getAffection().getName(),
					prediction.getProbability().getLabel(),
					prediction.getJustification()));
		}
	}
	
	public void add(Symptom symptom) {
		if (this.symptoms == null) {
			this.symptoms = new ArrayList<Symptom>();
		}
		this.symptoms.add(symptom);
	}
	
	public void add(RiskFactor riskFactor) {
		if (this.riskFactors == null) {
			this.riskFactors = new ArrayList<RiskFactor>();
		}
		this.riskFactors.add(riskFactor);
	}
	
	
	public List<Symptom> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	public List<RiskFactor> getRiskFactors() {
		return riskFactors;
	}
	public void setRiskFactors(List<RiskFactor> riskFactors) {
		this.riskFactors = riskFactors;
	}
	
}
