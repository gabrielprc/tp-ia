package main.java.model.constants;

public enum SymptomType {
	SENSITIVITY(1, "Sensibilidad"),
	PAIN(2, "Dolor"),
	INFLAMATION(3, "Inflamacion"),
	ORAL_HEALTH(4, "Salud");
	
	private int type;
	private String label;
	
	private SymptomType(int type, String label) {
		this.type = type;
		this.label = label;
	}
}
