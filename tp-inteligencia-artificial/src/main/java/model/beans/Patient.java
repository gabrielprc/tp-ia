package main.java.model.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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

}
