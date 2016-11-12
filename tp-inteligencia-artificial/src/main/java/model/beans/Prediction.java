package main.java.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.java.model.constants.Probability;
import main.java.model.views.PredictionView;

@Entity
@Table(name = "predictions")
public class Prediction extends BasicBean {
	
	private Patient patient;
	private Affection affection;
	private Probability probability;
	
	
	public Prediction() {
		super();
	}
	
	public Prediction(Patient patient, Affection affection,
			Probability probability) {
		super();
		this.patient = patient;
		this.affection = affection;
		this.probability = probability;
	}
	
	public Prediction(Long id, Patient patient, Affection affection,
			Probability probability) {
		super(id);
		this.patient = patient;
		this.affection = affection;
		this.probability = probability;
	}
	
	
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
	
	public PredictionView toView() {
		return new PredictionView(
			id,
			patient != null ? patient.toView() : null,
			affection != null ? affection.toView() : null,
			probability
		);
	}
	
	public static Prediction fromView(PredictionView view) {
		return new Prediction(
			view.getPatient() != null ? Patient.fromView(view.getPatient()) : null,
			view.getAffection() != null ? Affection.fromView(view.getAffection()) : null,
			view.getProbability()
		);
	}
	
}
