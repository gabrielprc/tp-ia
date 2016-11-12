package main.java.model.views;

import java.util.List;

public class PatientView extends BasicView {

	private String name;
	private List<SymptomView> symptoms;
	private List<RiskFactorView> riskFactors;
	
	public PatientView(String name, List<SymptomView> symptoms,
			List<RiskFactorView> riskFactors) {
		super();
		this.name = name;
		this.symptoms = symptoms;
		this.riskFactors = riskFactors;
	}
	
	public PatientView(Long id, String name, List<SymptomView> symptoms,
			List<RiskFactorView> riskFactors) {
		super(id);
		this.name = name;
		this.symptoms = symptoms;
		this.riskFactors = riskFactors;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SymptomView> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<SymptomView> symptoms) {
		this.symptoms = symptoms;
	}
	public List<RiskFactorView> getRiskFactors() {
		return riskFactors;
	}
	public void setRiskFactors(List<RiskFactorView> riskFactors) {
		this.riskFactors = riskFactors;
	}
	
}
