package main.java.model.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import main.java.model.views.PatientView;
import main.java.model.views.RiskFactorView;
import main.java.model.views.SymptomView;

@Entity
@Table(name = "patients")
public class Patient extends BasicBean {

	private String name;
	private List<Symptom> symptoms;
	private List<RiskFactor> riskFactors;
	
	public Patient() {
		super();
	}
	
	public Patient(String name, List<Symptom> symptoms, List<RiskFactor> riskFactors) {
		super();
		this.name = name;
		this.symptoms = symptoms;
		this.riskFactors = riskFactors;
	}
	
	public Patient(Long id, String name, List<Symptom> symptoms, List<RiskFactor> riskFactors) {
		super(id);
		this.name = name;
		this.symptoms = symptoms;
		this.riskFactors = riskFactors;
	}
	
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany
	@JoinTable(
		name = "patient_symptoms", 
		joinColumns = {@JoinColumn(name = "id_patient")},
		inverseJoinColumns = {@JoinColumn(name = "id_symptom")}
	)
	public List<Symptom> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	@ManyToMany
	@JoinTable(
		name = "patient_risk_factors", 
		joinColumns = {@JoinColumn(name = "id_patient")},
		inverseJoinColumns = {@JoinColumn(name = "id_risk_factor")}
	)
	public List<RiskFactor> getRiskFactors() {
		return riskFactors;
	}
	public void setRiskFactors(List<RiskFactor> riskFactors) {
		this.riskFactors = riskFactors;
	}
	
	public PatientView toView() {
		List<SymptomView> symptomViews = new ArrayList<SymptomView>();
		List<RiskFactorView> riskFactorViews = new ArrayList<RiskFactorView>();
		
		if (symptoms != null) {
			for (Symptom s : symptoms) {
				symptomViews.add(s.toView());
			}
		}
		
		if (riskFactors != null) {
			for (RiskFactor r : riskFactors) {
				riskFactorViews.add(r.toView());
			}
		}
		
		return new PatientView(id, name, symptomViews, riskFactorViews);
	}
	
	public static Patient fromView(PatientView view) {
		List<Symptom> symptoms = new ArrayList<Symptom>();
		List<RiskFactor> riskFactors = new ArrayList<RiskFactor>();
		
		if (view.getSymptoms() != null) {
			for (SymptomView sw : view.getSymptoms()) {
				symptoms.add(Symptom.fromView(sw));
			}
		}
		
		if (view.getRiskFactors() != null) {
			for (RiskFactorView rw : view.getRiskFactors()) {
				riskFactors.add(RiskFactor.fromView(rw));
			}
		}
		
		return new Patient(view.getName(), symptoms, riskFactors);
	}

}
