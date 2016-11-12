package main.java.model.views;

import main.java.model.constants.Probability;

public class PredictionView extends BasicView {

	private PatientView patient;
	private AffectionView affection;
	private Probability probability;
	
	public PredictionView(PatientView patient, AffectionView affection,
			Probability probability) {
		super();
		this.patient = patient;
		this.affection = affection;
		this.probability = probability;
	}
	
	public PredictionView(Long id, PatientView patient, AffectionView affection,
			Probability probability) {
		super(id);
		this.patient = patient;
		this.affection = affection;
		this.probability = probability;
	}
	
	
	public PatientView getPatient() {
		return patient;
	}
	public void setPatient(PatientView patient) {
		this.patient = patient;
	}
	public AffectionView getAffection() {
		return affection;
	}
	public void setAffection(AffectionView affection) {
		this.affection = affection;
	}
	public Probability getProbability() {
		return probability;
	}
	public void setProbability(Probability probability) {
		this.probability = probability;
	}
	
}
