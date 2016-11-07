package main.java.model.constants;

public enum RiskFactorType {
	DISEASE(1, "Enfermedad"),
	HABIT(2, "Habito");
	
	private int type;
	private String label;
	
	private RiskFactorType(int type, String label) {
		this.type = type;
		this.label = label;
	}
}
