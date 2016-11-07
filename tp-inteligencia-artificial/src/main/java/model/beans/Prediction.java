package main.java.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.java.model.constants.Probability;

@Entity
@Table(name = "predictions")
public class Prediction extends BasicBean {
	
	private Patient patient;
	private Affection affection;
	private Probability probability;
	
	@ManyToOne
	@JoinColumn(name = "id_patient")
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@ManyToOne
	@JoinColumn(name = "id_affection")
	public Affection getAffection() {
		return affection;
	}
	public void setAffection(Affection affection) {
		this.affection = affection;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "probability")
	public Probability getProbability() {
		return probability;
	}
	public void setProbability(Probability probability) {
		this.probability = probability;
	}
	
}
